package com.MTParking.model;

import java.sql.Timestamp;

public class Vehicle {

    private String registrationNumber;

    private boolean drivenByElderly;

    private boolean isRoyalFamily;

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Timestamp entryTime) {
        this.entryTime = entryTime;
    }

    private Timestamp entryTime;

    public boolean isDrivenByElderly() {
        return drivenByElderly;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setDrivenByElderly(boolean drivenByElderly) {
        this.drivenByElderly = drivenByElderly;
    }

    public boolean isRoyalFamily() {
        return isRoyalFamily;
    }

    public void setRoyalFamily(boolean royalFamily) {
        isRoyalFamily = royalFamily;
    }
}
