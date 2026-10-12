package ma.youcode.clicktrack.model;

import ma.youcode.clicktrack.model.enums.Category;

public class Publisher {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private Category category;

    public Publisher(String first_name, String last_name, String email, Category categorie) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.category = categorie;
    }

    public Publisher(Long id, String first_name, String last_name, String email, Category categorie) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.category = categorie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFullName() {
        return first_name + " " + last_name;
    }
}
