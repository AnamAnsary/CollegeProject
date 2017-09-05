package com.example.vmplapp.logindemo;

/**
 * Created by vmplapp on 4/9/17.
 */

public class MstLecture {

    int lecid;
    String lecdate;
    int lecHourStart;
    int lecMinStart;
    int lecHourEnd;
    int lecMinEnd;
    String subject;
    int userid;

    public int getLecid() {
        return lecid;
    }

    public void setLecid(int lecid) {
        this.lecid = lecid;
    }

    public String getLecdate() {
        return lecdate;
    }

    public void setLecdate(String lecdate) {
        this.lecdate = lecdate;
    }

    public int getLecHourStart() {
        return lecHourStart;
    }

    public void setLecHourStart(int lecHourStart) {
        this.lecHourStart = lecHourStart;
    }

    public int getLecMinStart() {
        return lecMinStart;
    }

    public void setLecMinStart(int lecMinStart) {
        this.lecMinStart = lecMinStart;
    }

    public int getLecHourEnd() {
        return lecHourEnd;
    }

    public void setLecHourEnd(int lecHourEnd) {
        this.lecHourEnd = lecHourEnd;
    }

    public int getLecMinEnd() {
        return lecMinEnd;
    }

    public void setLecMinEnd(int lecMinEnd) {
        this.lecMinEnd = lecMinEnd;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public MstLecture(int lecid, String lecdate, int lecHourStart, int lecMinStart, int lecHourEnd, int lecMinEnd, String subject, int userid) {

        this.lecid = lecid;
        this.lecdate = lecdate;
        this.lecHourStart = lecHourStart;
        this.lecMinStart = lecMinStart;
        this.lecHourEnd = lecHourEnd;
        this.lecMinEnd = lecMinEnd;
        this.subject = subject;
        this.userid = userid;
    }
}
