package com.jan1ooo.cloudparking.repository;

import com.jan1ooo.cloudparking.model.Parking;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String>{
}
