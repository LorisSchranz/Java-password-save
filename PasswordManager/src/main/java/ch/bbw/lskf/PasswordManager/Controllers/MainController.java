package ch.bbw.lskf.PasswordManager.Controllers;

import ch.bbw.lskf.PasswordManager.Models.Password;
import ch.bbw.lskf.PasswordManager.Models.User;
import ch.bbw.lskf.PasswordManager.Services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private FileService fileService;
//public PasswordController  passwordController = new PasswordController();

    // Login
    @GetMapping("/")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "World") String login, Model model, User user) {
        model.addAttribute("login", login);
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user) {
        return "redirect:/password";
    }


    @GetMapping("/password")
    public String password(Model model) {
        model.addAttribute("passwords", fileService.getPasswords());
        return "password";
    }

    // Creating Entries
    @GetMapping("/newEntry")
    public String entry(Model model, Password password) {
        model.addAttribute("password", password);
        return "newEntry";
    }

    @PostMapping("/createEntry")
    public String newEntry(@ModelAttribute Password password) {
        if (password.getId() == 0) {
            password.setId(fileService.getPasswords().size() + 1);
        }
        FileService.writeFile(password);
        return "redirect:/password";
    }

    // Editing Entries
    @GetMapping("/openEntry")
    public String openEntry(Model model, @RequestParam int id) {
        model.addAttribute("password", fileService.getPasswordByID(id));
        fileService.removeByID(id);
        FileService.rewriteFile();
        return "newEntry";
    }


    // Delete Entries
    @GetMapping("/deleteEntry")
    public String deleteEntry(@RequestParam int id) {
        fileService.removeByID(id);
        return "redirect:/password";
    }
}
