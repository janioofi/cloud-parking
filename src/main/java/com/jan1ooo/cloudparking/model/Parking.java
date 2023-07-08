package com.jan1ooo.cloudparking.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime entryDate = LocalDateTime.now();

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime exitDate;
    private Double bill;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Parking parking = (Parking) o;
        return getId_parking() != null && Objects.equals(getId_parking(), parking.getId_parking());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }
}
