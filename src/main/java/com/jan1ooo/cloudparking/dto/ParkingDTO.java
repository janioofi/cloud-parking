package com.jan1ooo.cloudparking.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ParkingDTO {
    private Long id_parking;

    @NotEmpty
    private String license;

    @NotEmpty
    private String state;

    @NotEmpty
    private String model;

    @NotEmpty
    private String color;

    private LocalDateTime entryDate;
    private LocalDateTime exitDate;
    private Double bill;
    public ParkingDTO( String license, String state, String model, String color) {
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
    }
}
