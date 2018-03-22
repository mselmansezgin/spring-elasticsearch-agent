package com.ets.elast4crm.model;

import io.searchbox.annotations.JestId;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Note implements Serializable {
    private static final long serialVersionUID = -3971912226293959387L;

    @JestId
    private String id;

    private String note;

    private Date createdOn;

    private String userName;

    private List<Detail> details;

    public Note(final String userName, final String note, final List<Detail> details) {
        this.userName = userName;
        this.note = note;
        this.createdOn = new Date();
        this.details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Detail> getDetail() { return details; }

    public void setDetail(Detail detail) {  this.details = details; }

    @Override
    public String toString() {
        return "Note{" +
                "id='" + id + '\'' +
                ", note='" + note + '\'' +
                ", createdOn=" + createdOn +
                ", userName='" + userName + '\'' +
                ", detail=" + details +
                '}';
    }
}
