package com.ets.elast4crm.model;

import java.util.Date;

public class InnerDetail {

    private String information;

    private Date detailDate;

    public InnerDetail(String information, Date detailDate){
        this.information = information;
        this.detailDate = detailDate;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Date getDetailDate() {
        return detailDate;
    }

    public void setDetailDate(Date detailDate) {
        this.detailDate = detailDate;
    }



    @Override
    public String toString() {
        return "InnerDetail{" +
                "information='" + information + '\'' +
                ", detailDate=" + detailDate +
                '}';
    }
}
