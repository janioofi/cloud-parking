package com.jan1ooo.cloudparking.exception;

import com.jan1ooo.cloudparking.model.Parking;

public class ParkingNotFoundException extends RuntimeException {

    public ParkingNotFoundException(Long id){
        super("Parking not found with Id: " + id);
    }

}
