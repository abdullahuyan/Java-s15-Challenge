package com.library.models;

import java.util.Date;

public class memberRecord {
    private int memberId;
    private String type;
    private Date dateOfMembership;
    private int maxBookLimit;
    private String name;
    private String address;
    private String phoneNo;
    private int noBooksIssued;

    public memberRecord(int memberId, String type, Date dateOfMembership, int maxBookLimit, String name, String address, String phoneNo) {
        this.memberId = memberId;
        this.type = type;
        this.dateOfMembership = dateOfMembership;
        this.maxBookLimit = maxBookLimit;
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.noBooksIssued = 0;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getType() {
        return type;
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public int getMaxBookLimit() {
        return maxBookLimit;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public int getNoBooksIssued() {
        return noBooksIssued;
    }

    public void incBookIssued() {
        if (noBooksIssued < maxBookLimit) {
            noBooksIssued++;
        }
    }

    public void decBookIssued() {
        if (noBooksIssued > 0) {
            noBooksIssued--;
        }
    }
}
