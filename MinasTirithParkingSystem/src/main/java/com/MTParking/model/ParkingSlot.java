package com.MTParking.model;

public class ParkingSlot {

    private Integer slotNumber;
    private Vehicle vehicle;

    private boolean isFilled;

    private boolean isCarSlot;

    private boolean isBikeSlot;

    public ParkingSlot() {
    }

    public ParkingSlot(boolean isCarSlot) {
        if(isCarSlot){
            this.isCarSlot = isCarSlot;
        }else {
            this.isBikeSlot = true;
        }

        setFilled(false);
    }

    public boolean isBikeSlot() {
        return isBikeSlot;
    }

    public void setBikeSlot(boolean bikeSlot) {
        isBikeSlot = bikeSlot;
    }

    public boolean isCarSlot() {
        return isCarSlot;
    }

    public void setCarSlot(boolean carSlot) {
        isCarSlot = carSlot;
    }



    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    private boolean isPath;

    public boolean isPath() {
        return isPath;
    }

    public void setPath(boolean path) {
        isPath = path;
    }

    @Override
    public String toString() {
        if(isPath()){
            return "-";
        }else if(isFilled) {
            return "F";
        }else {
            return "P";
        }
    }
}
