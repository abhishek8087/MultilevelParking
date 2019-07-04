package com.MTParking.worker;

import com.MTParking.model.Bike;
import com.MTParking.model.Car;
import com.MTParking.model.Floor;
import com.MTParking.model.Vehicle;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MinasTirithAppStart {

    public static void main(String[] args) {

        System.out.println("Welcome to Minas Tirith Central Parking");
        List<Floor> building = new ArrayList<Floor>();
        Scanner sc = new Scanner(System.in);
        System.out.println("*********************************************************************************");
        System.out.println("Application Setup START...");
        System.out.println( "Enter number of floor: ");
        try {
            int floors = sc.nextInt();
            System.out.println("Setting up parking for "+floors+" floors");

            Integer floorNo =0;
            while(floors>0){


               Floor fl = new Floor(++floorNo);
                System.out.println("How many slots out of 20 you want to be configured for Cars for floor number "+ floorNo + "? : ");
                int carSlots = sc.nextInt();
                fl.setCarorBikeSlots(carSlots);
                building.add(fl);
               floors--;
            }
            System.out.println("Application Setup END...");
            System.out.println("*********************************************************************************");
            for(Floor floor : building){
                floor.displayFloor();
            }
            boolean remove = false;
            String response = null;
            String rem = null;
            int corBRemove = 0;
            while (true) {
                try {
                    System.out.println("Vehicle Outgoing or Incoming? \n 1. Incoming 2. Outgoing");
                    Vehicle vehicle = null;
                    int incOut = sc.nextInt();
                    if (incOut == 2) {
                        System.out.println("Which type of vehicle ? \n 1.Car or 2.Bike?");
                        corBRemove = sc.nextInt();

                        System.out.println("Vehicle number : ");
                        rem = sc.next();

                        remove = true;
                    } else if (incOut == 1) {

                        System.out.println("Which type of vehicle ? \n 1.Car or 2.Bike?");
                        int carOrBike = sc.nextInt();

                        if (carOrBike == 1) {
                            Car c = new Car();
                            System.out.println("Enter number of passengers :");
                            c.setNumberOfPassengers(sc.nextInt());
                            vehicle = c;
                        } else {
                            vehicle = new Bike();
                        }
                        System.out.println("Enter Registration number : ");
                        vehicle.setRegistrationNumber(sc.next());
                        System.out.println("Driven by elderly ? \n  Y or N");
                        response = sc.next();
                        if (response.equals("Y") || response.equals("N"))
                            vehicle.setDrivenByElderly(response.equals("Y"));
                        else
                            break;
                        if (vehicle instanceof Car) {
                            System.out.println("Driven by royal family ? \n Y or N");
                            response = sc.next();
                            if (response.equals("Y") || response.equals("N"))
                                vehicle.setRoyalFamily(response.equals("Y"));
                            else
                                break;
                        }

                        remove = false;
                    }
                    for (Floor floor : building) {
                        if (!remove) {
                            vehicle.setEntryTime(new Timestamp(System.currentTimeMillis()));
                            if (vehicle instanceof Car) {
                                if (!floor.isCarsEmpty()) {

                                    if (vehicle.isRoyalFamily())
                                        System.out.println("Slot number allotted : " + floor.addRoyalCar((Car) vehicle));
                                    else
                                        System.out.println("Slot number allotted : " + floor.addCar((Car) vehicle));


                                    for (Floor perFloor : building) {
                                        perFloor.displayFloor();
                                    }
                                    break;
                                }
                            } else {
                                if (!floor.isBikesEmpty()) {
                                    vehicle.setEntryTime(new Timestamp(System.currentTimeMillis()));
                                    String slotNumber = floor.addBike((Bike) vehicle);
                                    if (slotNumber == null) {
                                        System.out.println("All bike slots are full. \n Would you like to convert a Car parking slot to Bike parking slot? \n Y/N");
                                        response = sc.next();
                                        if (response.equals("Y") || response.equals("N")) {
                                            System.out.println(floor.convertCarParkingtoBike());
                                        } else
                                            break;
                                    } else {
                                        System.out.println("Slot number allotted : " + slotNumber);
                                    }

                                    for (Floor perFloor : building) {
                                        perFloor.displayFloor();
                                    }
                                    break;
                                }
                            }
                        } else {
                            if (corBRemove == 1) {
                                Car f = new Car();
                                f.setRegistrationNumber(rem);
                                System.out.println(floor.removeCar(f));
                                for (Floor perFloor : building) {
                                    perFloor.displayFloor();
                                }
                                break;
                            } else if (corBRemove == 2) {
                                Bike b = new Bike();
                                b.setRegistrationNumber(rem);
                                System.out.println(floor.removeBike(b));
                                for (Floor perFloor : building) {
                                    perFloor.displayFloor();
                                }
                                break;
                            }
                        }

                    }
                }catch (InputMismatchException e){
                    System.out.println("Wrong input");
                    break;
                }catch (Exception e){
                    System.out.println("Wrong input");
                    continue;
                }


            }


        }catch (InputMismatchException in){
            System.out.println("Number of floors should be numeric.");
        }



    }
}
