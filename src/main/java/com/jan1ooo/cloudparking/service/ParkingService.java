package com.jan1ooo.cloudparking.service;

import com.jan1ooo.cloudparking.dto.ParkingDTO;
import com.jan1ooo.cloudparking.dto.mapper.ParkingMapper;
import com.jan1ooo.cloudparking.model.Parking;
import com.jan1ooo.cloudparking.repository.ParkingRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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

    public ParkingDTO findById(Long id){
        return parkingMapper.toDto(parkingRepository.findById(id).get());
    }

    public ParkingDTO create(@Valid @NotNull ParkingDTO parking){
        return parkingMapper.toDto(parkingRepository.save(parkingMapper.toEntity(parking)));
    }

}
