package com.MTParking.model;

import com.MTParking.singleton.CustomerStore;

import java.sql.Timestamp;
import java.util.*;

public class Floor {

    ParkingSlot slots[][];

    private boolean carsEmpty;
    private boolean bikesEmpty;

    public boolean isCarsEmpty() {
        return carsEmpty;
    }

    public void setCarsEmpty(boolean carsEmpty) {
        this.carsEmpty = carsEmpty;
    }

    public boolean isBikesEmpty() {
        return bikesEmpty;
    }

    public void setBikesEmpty(boolean bikesEmpty) {
        this.bikesEmpty = bikesEmpty;
    }

    private boolean isAvailable;
    private Integer floorNumber;
    private Integer lastSlot=0;
    private List<Integer> availableSlots;

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        slots = new ParkingSlot[6][5];
        for(int i=0; i<6;i++)
            for(int j = 0; j<5 ; j++) {
                slots[i][j] = new ParkingSlot();
            }


        for(int i=0; i<5;i++){
            slots[1][i].setPath(true);
            slots[4][i].setPath(true);
        }
    }

    public void setCarorBikeSlots(int noOfCarSlots){
        for(int i=0; i<6;i++)
            for(int j = 0; j<5 ; j++) {
                if(!slots[i][j].isPath()) {
                    if (noOfCarSlots > 0) {
                        slots[i][j] = new ParkingSlot(true);
                    } else {
                        slots[i][j] = new ParkingSlot(false);
                    }
                    noOfCarSlots--;
                }
            }
    }

    public void displayFloor() {

        System.out.println("Current parking status for Floor #"+getFloorNumber());
        for (ParkingSlot[] row : slots) {
            if(row instanceof CarParkingSlot[]){
                System.out.println(Arrays.toString(row));
            }
            else if(row instanceof BikeParkingSlot[]){
                System.out.println("rr");
            }
            else  {
                System.out.println(Arrays.toString(row));
            }

        }
    }
    public boolean isFilled(){
        for(int i=0; i<6;i++)
            for (int j = 0; j < 5; j++)
                if(!slots[i][j].isFilled())
                    return false;

        return true;

    }
    public String addCar(Car car){

        for(int i=0; i<6;i++) {
            for (int j = 0; j < 5; j++) {

                if(!slots[i][j].isPath() && !slots[i][j].isBikeSlot() && !slots[i][j].isFilled()){
                    int deck=0;
                    if(!(slots[i][j] instanceof CarParkingSlot))
                     slots[i][j] = new CarParkingSlot();
                    slots[i][j].setCarSlot(true);
                    CarParkingSlot cPs = (CarParkingSlot) slots[i][j];

                    for(int slot=0; slot<2;slot++){
                        if(cPs.getSlot()[slot].getRegistrationNumber()==null){
                            cPs.setSlot(car,slot);
                            deck=slot;
                            if(slot==1){
                                slots[i][j].setFilled(true);
                            }
                            break;
                        }
                    }

                    slots[i][j] = cPs;
                    String slot = getFloorNumber().toString() + i + j + deck;
                    slots[i][j].setSlotNumber(Integer.parseInt(slot));
                    return slot;
                }
            }
        }
        setCarsEmpty(true);
        return "Car slots are full!!";
    }

    public String addBike(Bike bike){
        for(int i=0; i<6;i++) {
            for (int j = 0; j < 5; j++) {

                if(!slots[i][j].isPath() && !slots[i][j].isCarSlot()  && !slots[i][j].isFilled()){
                    int deck=0;
                    if(!(slots[i][j] instanceof BikeParkingSlot))
                        slots[i][j] = new BikeParkingSlot();
                    slots[i][j].setBikeSlot(true);


                    BikeParkingSlot cPs = (BikeParkingSlot) slots[i][j];

                    for(int slot=0; slot<5;slot++){
                        if(cPs.getBikes()[slot].getRegistrationNumber()==null){
                            cPs.setBikes(bike,slot);
                            deck=slot;
                            if(slot==4){
                                slots[i][j].setFilled(true);
                            }
                            break;
                        }
                    }

                    slots[i][j] = cPs;
                    String slot = getFloorNumber().toString() + i + j + deck;
                    slots[i][j].setSlotNumber(Integer.parseInt(slot));
                    return slot;
                }
            }
        }
        return null;
    }

    public String  removeCar(Car car){
        for(int i=0; i<6;i++) {
            for (int j = 0; j < 5; j++) {
                if(slots[i][j] instanceof CarParkingSlot){
                    CarParkingSlot cpSlot = (CarParkingSlot) slots[i][j];
                    for(int h=0; h<2 ; h++){
                        if(cpSlot.getSlot()[h].getRegistrationNumber() !=null && cpSlot.getSlot()[h].getRegistrationNumber().equalsIgnoreCase(car.getRegistrationNumber())){
                            car.setEntryTime(cpSlot.getSlot()[h].getEntryTime());
                            cpSlot.setSlot(new Car(),h);
                            slots[i][j].setFilled(false);
                            CustomerStore.getInstance().prevCustomers.add(car.getRegistrationNumber());
                            System.out.println("Previous customers : "+CustomerStore.getInstance().prevCustomers);
                            System.out.println("Price to be payed : " + billCustomer(car));
                            return "removed";
                        }
                    }
                }
            }
        }
        return "This car is not parked here.";
    }

    public String  removeBike(Bike bike){
        for(int i=0; i<6;i++) {
            for (int j = 0; j < 5; j++) {
                if(slots[i][j] instanceof BikeParkingSlot){
                    BikeParkingSlot cpSlot = (BikeParkingSlot) slots[i][j];
                    for(int h=0; h<5 ; h++){
                        if(cpSlot.getBikes()[h].getRegistrationNumber() !=null && cpSlot.getBikes()[h].getRegistrationNumber().equalsIgnoreCase(bike.getRegistrationNumber())){
                            bike.setEntryTime(cpSlot.getBikes()[h].getEntryTime());
                            cpSlot.setBikes(new Bike(),h);
                            slots[i][j].setFilled(false);
                            CustomerStore.getInstance().prevCustomers.add(bike.getRegistrationNumber());
                            System.out.println("Previous customers : "+CustomerStore.getInstance().prevCustomers);
                            System.out.println("Price to be payed : " + billCustomer(bike));
                            return "removed";
                        }
                    }
                }
            }
        }
        return "This bike is not parked here.";
    }


    public String convertCarParkingtoBike(){
        for(int i=0; i<6;i++) {
            for (int j = 0; j < 5; j++) {
                if(!(slots[i][j] instanceof CarParkingSlot)  && !slots[i][j].isFilled() && !slots[i][j].isPath()){

                    slots[i][j] = new BikeParkingSlot();
                    slots[i][j].setBikeSlot(true);
                    return "1 bike slot added.";
                }
            }
        }
        setBikesEmpty(true);
        return "All slots are full";
    }

    private static int[][] directions = new int[][]{{-1,-1}, {-1,0}, {-1,1},  {0,1}, {1,1},  {1,0},  {1,-1},  {0, -1}};

    public String addRoyalCar(Car car){


        for(int i=0; i<6;i++) {
            for (int j = 0; j < 5; j++) {
                try{
                    List<CoOrdinates> surrCod = new ArrayList<CoOrdinates>();
                    boolean condi = true;
                    if(!slots[i][j].isFilled() && !slots[i][j].isPath() && !(slots[i][j] instanceof CarParkingSlot) && !(slots[i][j] instanceof BikeParkingSlot) ) {
                        for (int[] direction : directions) {
                            int cx = i + direction[0];
                            int cy = j + direction[1];
                            if (cy >= 0 && cy < slots.length)
                                if (cx >= 0 && cx <= slots[cy].length) {
                                    if (slots[cx][cy].isFilled() || slots[cx][cy] instanceof CarParkingSlot) {
                                        condi = false;
                                        break;
                                    } else {
                                        if(!slots[cx][cy].isPath()) {
                                            System.out.println(cx + " " + cy);
                                            surrCod.add(new CoOrdinates(cx,cy));

                                        }
                                    }
                                }
                        }

                        if(condi){
                            int deck = 0;
                            if(!(slots[i][j] instanceof CarParkingSlot))
                                slots[i][j] = new CarParkingSlot();
                            slots[i][j].setCarSlot(true);
                            CarParkingSlot cPs = (CarParkingSlot) slots[i][j];

                            for(int slot=0; slot<2;slot++){
                                if(cPs.getSlot()[slot].getRegistrationNumber()==null){
                                    cPs.setSlot(car,slot);
                                    deck=slot;
                                    slots[i][j].setFilled(true);
                                    break;
                                }
                            }
                            for(CoOrdinates coOrdinates : surrCod){
                                slots[coOrdinates.getX()][coOrdinates.getY()].setFilled(true);
                            }
                            cPs.setSlot(new Car(),1);
                            slots[i][j] = cPs;
                            String slot = getFloorNumber().toString() + i + j + deck;
                            slots[i][j].setSlotNumber(Integer.parseInt(slot));

                            return slot;
                        }

                    }

                }catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }

    public double billCustomer(Vehicle vehicle){
        double carRates = 10;
        double bikeRates = 5;
        double price = 0.0;
        double minutes = getTimeDifference(vehicle.getEntryTime(),new Timestamp(System.currentTimeMillis()));
        if(CustomerStore.getInstance().prevCustomers.contains(vehicle.getRegistrationNumber())){
            minutes = minutes * 0.9;
        }
        if(vehicle instanceof Car){
            price = minutes * carRates;
            if(((Car) vehicle).getNumberOfPassengers() > 1){
                if(price - 10 >0) {
                    price -= 10;
                    System.out.println("Car pool offer applied!");
                }
            }
        }else {
            price = minutes * bikeRates;
        }
        return price;
    }

    public Integer getTimeDifference(Timestamp timestamp1, Timestamp timestamp2){
        long milliseconds = timestamp2.getTime() - timestamp1.getTime();
        int seconds = (int) milliseconds / 1000;
        int minutes = (seconds % 3600) / 60;
        System.out.println(" Minutes: " + minutes);
        return minutes;
    }
}
