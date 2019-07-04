package com.MTParking.model;

import java.util.Arrays;
import java.util.List;

public class CarParkingSlot extends ParkingSlot{



    Car[] slot  = {new Car(), new Car()};

    public Car[] getSlot() {
        return slot;
    }

    public void setSlot(Car car, int slot) {
        this.slot[slot] = car;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for(int i=0 ; i<2 ; i++)
        {
            if( slot[i].getRegistrationNumber() != null) {
                if (i == 0)
                    sb.append("Upper slot : " + slot[i].getRegistrationNumber() + " ");
                else
                    sb.append("Lower slot : " + slot[i].getRegistrationNumber());
            }else{
                sb.append(" NF ");
            }
        }
        return sb.toString();
    }
}
