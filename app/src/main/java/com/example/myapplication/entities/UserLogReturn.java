package com.example.myapplication.entities;

public class UserLogReturn {
    private String email, token;

    public UserLogReturn(String email, String password) {
        this.email = email;
        this.token = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
