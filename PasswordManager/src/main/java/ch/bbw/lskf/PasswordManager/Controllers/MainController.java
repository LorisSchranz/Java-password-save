package ch.bbw.lskf.PasswordManager.Controllers;

import ch.bbw.lskf.PasswordManager.Models.Password;
import ch.bbw.lskf.PasswordManager.Models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {
private ArrayList<Password> passwords = new ArrayList<>();
    @GetMapping("/")
    public String index(@RequestParam(name = "name", required = false, defaultValue = "World") String login, Model model, User user) {
        model.addAttribute("login", login);
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model, @ModelAttribute User user, Password password){
        if (user.getUsername().equals("Admin")){
            //TODO: json file with all passwords
        }
        model.addAttribute("passwords", passwords);
        return "password";
    }

    @GetMapping("/login")
    public String password(Model model, Password password) {
        model.addAttribute("password", password);
        return "password";
    }

    @GetMapping("/newEntry")
    public String entry(Model model, Password password) {
        model.addAttribute("password", password);
        return "newEntry";
    }

    @PostMapping("/createEntry")
    public String newEntry(Model model, @ModelAttribute Password password) {
        passwords.add(password);
        model.addAttribute("passwords", passwords);
        return "password";
    }

}
