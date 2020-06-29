package ch.bbw.lskf.PasswordManager.Services;

import ch.bbw.lskf.PasswordManager.Models.Password;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
@ApplicationScope
public class FileService {

    private static final AES AESService = new AES();

    private static ArrayList<Password> passwords = new ArrayList<>();

    private static ArrayList<Password> readFile() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            passwords = mapper.readValue(new File("D:\\workspace\\Java-Secure\\Java-password-save\\PasswordManager\\src\\main\\java\\ch\\bbw\\lskf\\PasswordManager\\Mock\\MockPassword.json"), mapper.getTypeFactory().constructCollectionType(List.class, Password.class));
            decryptPasswords();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passwords;
    }


    public static void writeFile(Password password) {
        passwords.add(password);
        rewriteFile();
    }

    public static void rewriteFile() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Object to JSON in file
            encryptPasswords();
            File file = new File("D:\\workspace\\Java-Secure\\Java-password-save\\PasswordManager\\src\\main\\java\\ch\\bbw\\lskf\\PasswordManager\\Mock\\MockPassword.json");

            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, false))); // append mode file writer

            mapper.writeValue(out, passwords);

        } catch (Exception e) {
            e.printStackTrace();
        }

        readFile();
    }

    private static void encryptPasswords() {
        for (Password password : passwords) {
            password.setValue(AESService.encrypt(password.getValue(), "test"));
        }
    }

    private static void decryptPasswords() {
        for (Password password : passwords) {
            password.setValue(AESService.decrypt(password.getValue(), "test"));
        }
    }

    public Password getPasswordByID(int id) {
        for (Password password : passwords) {
            if (password.getId() == id) {
                return password;
            }
        }
        return null;
    }

    public void removeByID(int id) {
        Password passwordToRemove = null;
        for (Password password : passwords) {
            if (password.getId() == id) {
                passwordToRemove = password;
            }
        }
        passwords.remove(passwordToRemove);
    }

    public ArrayList<Password> getPasswords() {
        return passwords;
    }
}
