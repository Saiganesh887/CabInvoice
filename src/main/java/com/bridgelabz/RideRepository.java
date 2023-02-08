package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;

public class RideRepository {
    static List<Customer> customerList = new ArrayList<>();
    public static Invoice generateInvoiceByUserId(int userId){
        Ride[] rides1 = {new Ride(10,5,RideType.NORMAL),new Ride(0.1,3,RideType.NORMAL),new Ride(5,9,RideType.NORMAL),new Ride(9,8,RideType.NORMAL)};
        Ride[] rides2 = {new Ride(10,6,RideType.PREMIUM),new Ride(0.1,3,RideType.PREMIUM),new Ride(5,9,RideType.PREMIUM),new Ride(9,8,RideType.PREMIUM)};
        customerList.add(new Customer(1,rides1));
        customerList.add(new Customer(2,rides2));
        for(Customer customer : customerList){
            if(customer.getId() == userId)
                return CabInvoice.generateInvoice(customer.getRides());
        }
        return null;
    }
}
