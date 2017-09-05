package com.example.vmplapp.logindemo;

/**
 * Created by vmplapp on 4/9/17.
 */

public class MstLibrary {

    int libid;
    String bookname;
    int active;

    public MstLibrary() {
    }

    public MstLibrary(int libid, String bookname, int active) {
        this.libid = libid;
        this.bookname = bookname;
        this.active = active;
    }

    public int getLibid() {
        return libid;
    }

    public void setLibid(int libid) {
        this.libid = libid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
