package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CabInvoiceTest {
    CabInvoice cabInvoice = new CabInvoice();
    @Test
    void givenDistanceAndTimeShouldReturnTotalFare(){
        double fare = cabInvoice.calculateFare(2.0,5.0);
        assertEquals(25,fare);
    }
    @Test
    void givenNumberOfRidesShouldReturnTotalFare(){
        Ride[] arr = {new Ride(2.0,5.0),new Ride(3.0,7.0),new Ride(0.1,0.3)};
        double fare1 = cabInvoice.calculateFare(arr);
        assertEquals(67,fare1);
    }
    @Test
    void givenMultipleRidesShouldReturnInvoice(){
        Ride[] arr = {new Ride(2.0,5.0),new Ride(3.0,7.0),new Ride(0.1,0.3)};
        Invoice actualInvoice = cabInvoice.generateInvoice(arr);
        Invoice expectedInvoice = new Invoice(67.0,3,67.0/3);
        assertEquals(expectedInvoice,actualInvoice);
    }

    @Test
    void givenUserIdShouldReturnInvoice(){
        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(2);
        Invoice expectedInvoice = new Invoice(268.0,4,67);
        assertEquals(expectedInvoice,actualInvoice);
    }

    @Test
    void givenRideTypeShouldReturnInvoice(){
        Invoice actualInvoice = RideRepository.generateInvoiceByUserId(1);
        Invoice expectedInvoice = new Invoice(267.0,4,66.75);
        assertEquals(expectedInvoice,actualInvoice);
    }


}
