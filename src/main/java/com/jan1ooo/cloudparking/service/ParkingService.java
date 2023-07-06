package com.jan1ooo.cloudparking.service;

import com.jan1ooo.cloudparking.dto.ParkingDTO;
import com.jan1ooo.cloudparking.dto.mapper.ParkingMapper;
import com.jan1ooo.cloudparking.exception.ParkingNotFoundException;
import com.jan1ooo.cloudparking.model.Parking;
import com.jan1ooo.cloudparking.repository.ParkingRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    @Autowired
    public ParkingRepository parkingRepository;

    @Autowired
    public ParkingMapper parkingMapper;

    public List<ParkingDTO> findAll(){
        return parkingRepository.findAll().stream().map(parkingMapper::toDto).collect(Collectors.toList());
    }

    public ParkingDTO findById(@Positive @NotNull Long id){
        return parkingRepository.findById(id).map(parkingMapper::toDto).orElseThrow(() -> new ParkingNotFoundException(id));
    }

    public ParkingDTO create(@Valid @NotNull ParkingDTO parking){
        return parkingMapper.toDto(parkingRepository.save(parkingMapper.toEntity(parking)));
    }

    public ParkingDTO update(@Positive @NotNull Long id, @Valid @NotNull ParkingDTO parking){
        return parkingRepository.findById(id)
                .map(parkingUpdate -> {
                    parkingUpdate.setLicense(parking.license());
                    parkingUpdate.setState(parking.state());
                    parkingUpdate.setModel(parking.model());
                    parkingUpdate.setColor(parking.color());
                    parkingUpdate.setBill(parking.bill());
                    return parkingMapper.toDto(parkingRepository.save(parkingUpdate));
                }).orElseThrow(() -> new ParkingNotFoundException(id));
    }

    public void delete(@Positive @NotNull Long id){
        parkingRepository.delete(parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id)));
    }

}
