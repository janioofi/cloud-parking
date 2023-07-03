package com.jan1ooo.cloudparking.controller;

import com.jan1ooo.cloudparking.dto.ParkingDTO;
import com.jan1ooo.cloudparking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @GetMapping
    public List<ParkingDTO> findAll(){
        return parkingService.findAll();
    }
}
