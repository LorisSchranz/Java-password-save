package ch.bbw.lskf.PasswordManager.Models;

public class PasswordModel {
    private String email;
    private String url;
    private String password;
    private String category;
    private String notes;
    public PasswordModel(String email, String url, String password, String notes, String category){
        this.email = email;
        this.url = url;
        this.password = password;
        this.notes = notes;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}