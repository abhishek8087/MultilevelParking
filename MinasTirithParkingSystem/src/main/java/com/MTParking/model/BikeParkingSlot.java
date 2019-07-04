package com.MTParking.model;

public class BikeParkingSlot extends ParkingSlot {

    Bike[] bikes = {new Bike(),new Bike(),new Bike(),new Bike(),new Bike()};

    public Bike[] getBikes() {
        return bikes;
    }

    public void setBikes(Bike bike , int slot) {
        this.bikes[slot] = bike;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        for(int i=0 ; i<5 ; i++)
        {
            if( bikes[i].getRegistrationNumber() != null) {
                if (i < 2)
                    sb.append("Upper slot : " + bikes[i].getRegistrationNumber() + " ");
                else
                    sb.append("Lower slot : " + bikes[i].getRegistrationNumber());
            }else{
                sb.append(" NF ");
            }
        }
        return sb.toString();
    }
}
