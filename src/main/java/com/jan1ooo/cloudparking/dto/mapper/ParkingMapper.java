package com.jan1ooo.cloudparking.dto.mapper;

import com.jan1ooo.cloudparking.dto.ParkingDTO;
import com.jan1ooo.cloudparking.model.Parking;
import org.springframework.stereotype.Component;

@Component
public class ParkingMapper {

    public Parking toEntity(ParkingDTO parkingDTO){
        if(parkingDTO.getId() == null){
            return null;
        }
        Parking parking = new Parking();
        if(parkingDTO.getId() != null){
            parking.setId(parkingDTO.getId());
        }
        parking.setColor(parkingDTO.getColor());
        parking.setModel(parkingDTO.getModel());
        parking.setLicense(parkingDTO.getLicense());
        parking.setState(parkingDTO.getState());
        parking.setBill(parkingDTO.getBill());
        parking.setEntryDate(parkingDTO.getEntryDate());
        parking.setExitDate(parkingDTO.getExitDate());
        return parking;
    }

    public ParkingDTO toDto(Parking parking){
        if(parking.getId() == null){
            return null;
        }
        ParkingDTO parkingDTO = new ParkingDTO();
        parkingDTO.setId(parking.getId());
        parkingDTO.setColor(parking.getColor());
        parkingDTO.setBill(parking.getBill());
        parkingDTO.setLicense(parking.getLicense());
        parkingDTO.setModel(parking.getModel());
        parkingDTO.setState(parking.getState());
        parkingDTO.setEntryDate(parking.getEntryDate());
        parkingDTO.setExitDate(parking.getExitDate());
        return parkingDTO;
    }
}
