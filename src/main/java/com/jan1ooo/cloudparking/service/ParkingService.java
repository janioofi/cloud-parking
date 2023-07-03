package com.jan1ooo.cloudparking.service;

import com.jan1ooo.cloudparking.dto.ParkingDTO;
import com.jan1ooo.cloudparking.dto.mapper.ParkingMapper;
import com.jan1ooo.cloudparking.model.Parking;
import com.jan1ooo.cloudparking.repository.ParkingRepository;
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

//    private static Map<String, ParkingDTO> parkingMap = new HashMap<>();

    public List<ParkingDTO> findAll(){
        parkingRepository.deleteAll();
        ParkingDTO parkingDTO = new ParkingDTO();
//        var id = getUUID();
        ParkingDTO parking = new ParkingDTO("ffd34234", "DSD-4241", "SP", "CELTA", "PRETO");
        parkingRepository.save(parkingMapper.toEntity(parking));
        return parkingRepository.findAll().stream().map(parkingMapper::toDto).collect(Collectors.toList());
    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
