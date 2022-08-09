package com.models;

public class UserAuthentication {
    private int id;
    private String userName;
    private String password;
    private String api_token;

    public UserAuthentication(int id, String userName, String password, String api_token) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.api_token = api_token;
    }

    public UserAuthentication(String userName, String password, String api_token) {
        this.userName = userName;
        this.password = password;
        this.api_token = api_token;
    }


    public UserAuthentication() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApi_token() {
        return api_token;
    }

    public void setApi_token(String api_token) {
        this.api_token = api_token;
    }

    @Override
    public String toString() {
        return "UserAuthentication{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", api_token='" + api_token + '\'' +
                '}';
    }
}
