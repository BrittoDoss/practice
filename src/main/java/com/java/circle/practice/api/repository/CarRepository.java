package com.java.circle.practice.api.repository;

import com.java.circle.practice.api.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long>{
    Car findByLicensePlate(String licensePlate);
}
