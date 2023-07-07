package com.jan1ooo.cloudparking.controller;

import com.jan1ooo.cloudparking.dto.ParkingDTO;
import com.jan1ooo.cloudparking.exception.ParkingNotFoundException;
import com.jan1ooo.cloudparking.service.ParkingService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.PersistenceException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Tag(name = "Parkings", description = "API Parking")
@RestController
@RequestMapping("/api/parking")
public class ParkingController {

    @Autowired
    private final ParkingService parkingService;


    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping
    public ResponseEntity<List<ParkingDTO>> findAll(){
        return ResponseEntity.ok().body(parkingService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParkingDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(parkingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ParkingDTO> create(@RequestBody @Valid ParkingDTO parking){
        return ResponseEntity.status(201).body(parkingService.create(parking));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParkingDTO> update(@PathVariable Long id, @RequestBody ParkingDTO parking){
        return ResponseEntity.status(204).body(parkingService.update(id, parking));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        parkingService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/exit/{id}")
    public ResponseEntity<Void> exit(@PathVariable Long id,@RequestBody ParkingDTO parkingDTO) {
        parkingService.exitDate(id, parkingDTO);
        parkingService.bill(id);
        return ResponseEntity.noContent().build();
    }
}