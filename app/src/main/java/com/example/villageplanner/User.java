package com.example.villageplanner;

import java.util.Map;

public class User {

    private String username;
    private String password;
    private String user_key;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(String username, String password, String user_key) {
        this.username = username;
        this.password = password;
        this.user_key = user_key;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUser_key() { return this.user_key;}

}