package com.jan1ooo.cloudparking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Parking(String license, String state, String model, String color) {
        this.license = license;
        this.state = state;
        this.model = model;
        this.color = color;
    }
}
