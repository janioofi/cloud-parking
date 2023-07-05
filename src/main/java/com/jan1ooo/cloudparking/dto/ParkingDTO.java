package com.jan1ooo.cloudparking.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record ParkingDTO(Long id_parking,
                         @NotEmpty String license,
                         @NotEmpty String state,
                         @NotEmpty String model,
                         @NotEmpty String color,
                         @JsonFormat(pattern = "dd-MM-yyyy HH:mm") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalDateTime entryDate,
                         @JsonFormat(pattern = "dd-MM-yyyy HH:mm") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalDateTime exitDate,
                         Double bill
                         ) {

}
