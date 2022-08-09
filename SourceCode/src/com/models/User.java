package com.models;

public class User {
    private int id;
    private String api_token;
    private String name;
    private String family;
    private String email;
    private String phone;

    public User(int id, String api_token, String name, String family, String email, String phone) {
        this.id = id;
        this.api_token = api_token;
        this.name = name;
        this.family = family;
        this.email = email;
        this.phone = phone;
    }

    public User(String api_token, String name, String family, String email, String phone) {
        this.api_token = api_token;
        this.name = name;
        this.family = family;
        this.email = email;
        this.phone = phone;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", api_token='" + api_token + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
