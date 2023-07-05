package com.jan1ooo.cloudparking.dto.mapper;

import com.jan1ooo.cloudparking.dto.ParkingDTO;
import com.jan1ooo.cloudparking.model.Parking;
import org.springframework.stereotype.Component;

@Component
public class ParkingMapper {

    public ParkingDTO toDto(Parking parking){
        if(parking == null){
            return null;
        }
        return new ParkingDTO(parking.getId_parking(),
                parking.getLicense(),
                parking.getState(),
                parking.getModel(),
                parking.getColor(),
                parking.getEntryDate(),
                parking.getExitDate(),
                parking.getBill());
    }

    public Parking toEntity(ParkingDTO parkingDTO){
        if(parkingDTO == null){
            return null;
        }
        Parking parking = new Parking();
        if(parkingDTO.id_parking() != null){
            parking.setId_parking(parkingDTO.id_parking());
        }
        parking.setColor(parkingDTO.color());
        parking.setModel(parkingDTO.model());
        parking.setLicense(parkingDTO.license());
        parking.setState(parkingDTO.state());
        parking.setBill(parkingDTO.bill());
        parking.setEntryDate(parkingDTO.entryDate());
        parking.setExitDate(parkingDTO.exitDate());
        return parking;
    }
}
