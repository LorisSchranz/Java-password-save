package ch.bbw.lskf.PasswordManager.Models;

public class Password {
    private String email;
    private String url;
    private String value;
    private String category;
    private String notes;

    public Password() {
        this("", "", "", "", "");
    }

    public Password(String email, String url, String value, String notes, String category) {
        this.email = email;
        this.url = url;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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