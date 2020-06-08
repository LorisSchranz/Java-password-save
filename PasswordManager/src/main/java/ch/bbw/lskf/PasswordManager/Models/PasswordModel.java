package ch.bbw.lskf.PasswordManager.Models;

public class PasswordModel {
    private String email;
    private String url;
    private String password;
    private String category;
    public PasswordModel(String email, String url, String password, String category){
        this.email = email;
        this.url = url;
        this.password = password;
        this.category = category;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}