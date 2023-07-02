package com.jan1ooo.cloudparking.controller;

import com.jan1ooo.cloudparking.model.Parking;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping
public class ParkingController {

    @GetMapping
    public List<Parking> findAll(){
        Parking parking = new Parking();
        parking.setId("1");
        parking.setColor("PRETO");
        parking.setModel("JETTA");
        parking.setLicense("JI33-39M");
        parking.setState("SP");

        return Arrays.asList(parking);
    }
}
