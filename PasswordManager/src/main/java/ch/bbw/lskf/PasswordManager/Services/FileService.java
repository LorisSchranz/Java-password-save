package ch.bbw.lskf.PasswordManager.Services;

import ch.bbw.lskf.PasswordManager.Models.Password;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class FileService {
    private ArrayList<Password> passwords = new ArrayList<>();

    private static Password readFile() {

        ObjectMapper mapper = new ObjectMapper();
        Password test = new Password();
        try {
            test = mapper.readValue(new File("D:\\workspace\\Java-Secure\\Java-password-save\\PasswordManager\\src\\main\\java\\ch\\bbw\\lskf\\PasswordManager\\Mock\\MockPassword.json"), Password.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return test;
    }

    public static void writeFile() {
        Password password = new Password("l.s@gmail.com","google.com", "Admin123","just a test", "business");

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("D:\\workspace\\Java-Secure\\Java-password-save\\PasswordManager\\src\\main\\java\\ch\\bbw\\lskf\\PasswordManager\\Mock\\MockPassword.json"), readFile() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        readFile();
    }
}
