package com.ets.elast4crm.model;

import java.util.Date;
import java.util.List;

public class Detail {

    private String note;

    private Date createdOn;

    private List<InnerDetail> inDet;

    public Detail(String note, Date date, List<InnerDetail> inDet) {
        this.createdOn = date;
        this.note = note;
        this.inDet = inDet;
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

    public List<InnerDetail> getInDet() {
        return inDet;
    }

    public void setInDet(List<InnerDetail> inDet) {
        this.inDet = inDet;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "note='" + note + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}
