package com.example.vmplapp.logindemo;

/**
 * Created by vmplapp on 4/9/17.
 */

public class MstDept {

    int deptid;
    String deptname;
    int deptHOD;
    int active;

//set constructors and getter and setter methods.


    public MstDept() {
    }

    public MstDept(int deptid, String deptname, int deptHOD) {
        this.deptid = deptid;
        this.deptname = deptname;
        this.deptHOD = deptHOD;
    }

    public int getActive() {
        return active;
    }

    public MstDept(String deptname, int deptHOD) {
        this.deptname = deptname;
        this.deptHOD = deptHOD;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getDeptid() {

        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public int getDeptHOD() {
        return deptHOD;
    }

    public void setDeptHOD(int deptHOD) {
        this.deptHOD = deptHOD;
    }
}

