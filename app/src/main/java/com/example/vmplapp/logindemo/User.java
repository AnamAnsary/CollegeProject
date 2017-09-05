package com.example.vmplapp.logindemo;

/**
 * Created by vmplapp on 28/8/17.
 */

public class User {

    //private variables
    int id;
    String user_name;
    String email;
    String password;

    // Empty constructor
    public User(){

    }

    public User(int id, String user_name, String email, String password) {
        this.id = id;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}