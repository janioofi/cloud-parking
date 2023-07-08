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

import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.LongFunction;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    @Autowired
    public ParkingRepository parkingRepository;

    private Parking parkingCalc;

    @Autowired
    public ParkingMapper parkingMapper;

    public List<ParkingDTO> findAll() {
        return parkingRepository.findAll().stream().map(parkingMapper::toDto).collect(Collectors.toList());
    }

    public ParkingDTO findById(@Positive @NotNull Long id) {
        return parkingRepository.findById(id).map(parkingMapper::toDto).orElseThrow(() -> new ParkingNotFoundException(id));
    }

    public ParkingDTO create(@Valid @NotNull ParkingDTO parking) {
        Parking parkingEntity = parkingMapper.toEntity(parking);
        parkingEntity.setEntryDate(LocalDateTime.now());
        parking = parkingMapper.toDto(parkingEntity);
        return parkingMapper.toDto(parkingRepository.save(parkingMapper.toEntity(parking)));
    }

    public ParkingDTO update(@Positive @NotNull Long id, @Valid @NotNull ParkingDTO parking) {
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

    public void delete(@Positive @NotNull Long id) {
        parkingRepository.delete(parkingRepository.findById(id).orElseThrow(() -> new ParkingNotFoundException(id)));
    }

    public Double calcTime(LocalDateTime entry, LocalDateTime exit, Long id) {
        Duration period = Duration.between(entry, exit);
        Long hours = period.toHours();
        Double price = 0.0;
        if (hours >= 0 && hours <= 3) {
            price += 14.5;
        } else if (hours > 3 && hours <= 7) {
            price += 13.5;
        } else if (hours > 7 && hours <= 13) {
            price += 12.8;
        } else if (hours > 13 && hours <= 17) {
            price += 11.9;
        } else {
            price += 11;
        }
        Double tot = price * hours;
        parkingRepository.findById(id)
                .map(up -> {
                    up.setBill(tot);
                    return parkingMapper.toDto(parkingRepository.save(up));
                })
                .orElseThrow(() -> new ParkingNotFoundException(id));
        return tot;
    }

    public ParkingDTO exitDate(@NotNull @Positive Long id, @NotNull @Valid ParkingDTO parking) {
        return parkingRepository.findById(id)
                .map(exit -> {
                    exit.setExitDate(parking.exitDate());
                    return parkingMapper.toDto(parkingRepository.save(exit));
                }).orElseThrow(() -> new ParkingNotFoundException(id));
    }

    public ParkingDTO bill(Long id){
        ParkingDTO parking = findById(id);
        calcTime(parking.entryDate(), parking.exitDate(), parking.id_parking());
        return parking;
    }


}
