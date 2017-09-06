package com.example.vmplapp.logindemo;

/**
 * Created by vmplapp on 4/9/17.
 */

public class MstUsers {

    int id;
    String username;
    String password;
    String fullname;
    String contactno;
    String email;
    String usertype;
    int isApproved;
    int active;


    public MstUsers(String username, String password, String fullname, String contactno, String email, String usertype, int isApproved, int active) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.contactno = contactno;
        this.email = email;
        this.usertype = usertype;
        this.isApproved = isApproved;
        this.active = active;
    }

    public MstUsers(int id, String username, String password, String fullname, String contactno, String email, String usertype, int isApproved, int active) {
        this.id = id;

        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.contactno = contactno;
        this.email = email;
        this.usertype = usertype;
        this.isApproved = isApproved;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public MstUsers() {
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
