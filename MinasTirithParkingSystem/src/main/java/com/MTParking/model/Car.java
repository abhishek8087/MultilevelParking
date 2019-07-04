package com.MTParking.model;

import java.sql.Timestamp;

public class Car extends Vehicle {

    private int numberOfPassengers;



    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
}
