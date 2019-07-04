package com.MTParking.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CustomerStore {

    private static CustomerStore instance;

    public static Set<String> getPrevCustomers() {
        return prevCustomers;
    }

    public static void setPrevCustomers(Set<String> prevCustomers) {
        CustomerStore.prevCustomers = prevCustomers;
    }

    public static Set<String> prevCustomers = new TreeSet<String>();
    private CustomerStore(){

    }

    public static synchronized CustomerStore getInstance(){
        if(instance == null){
            instance = new CustomerStore();
        }
        return instance;
    }

    static void addCustomer(String vehicleNo){
        prevCustomers.add(vehicleNo);
    }
}
