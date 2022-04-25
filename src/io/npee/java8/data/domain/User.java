package io.npee.java8.data.domain;

public class User {
    private final Long id;
    private String name;
    private String email;
    private String phone;

    public User(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "id = " + id +
                ", name = " + name +
                ", email = " + email +
                ", phone = " + phone;
    }
}
