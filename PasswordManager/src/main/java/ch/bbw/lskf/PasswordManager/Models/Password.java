package ch.bbw.lskf.PasswordManager.Models;

public class Password {
    private String url;
    private String email;
    private String value;
    private String notes;
    private String category;
    private int id;

    public Password() {
        this("", "", "", "", "", 0);
    }

    public Password(String url, String email, String value, String notes, String category, int id) {
        this.url = url;
        this.email = email;
        this.value = value;
        this.notes = notes;
        this.category = category;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}