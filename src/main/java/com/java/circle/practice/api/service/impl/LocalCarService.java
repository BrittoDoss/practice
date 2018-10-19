package com.java.circle.practice.api.service.impl;

import com.java.circle.practice.api.exception.CarException;
import com.java.circle.practice.api.model.Car;
import com.java.circle.practice.api.repository.CarRepository;
import com.java.circle.practice.api.service.CarService;
import com.java.circle.practice.api.service.TrackTime;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class LocalCarService implements CarService {

    private static final Logger logger = LoggerFactory.getLogger(LocalCarService.class);

    private CarRepository carRepository;

    @TrackTime
    @Override
    public Car getCar(String licensePlate) {
        logger.info("reading car details for License Plate - {}", licensePlate);
        Car aCar = carRepository.findByLicensePlate ( licensePlate );
        if (null != aCar) {
            return aCar;
        } else {
            try {
                Car car = new Car (  );
                car.setLicensePlate ( licensePlate );
                return carRepository.save ( car );
            } catch (Exception ex) {
                throw new CarException ( ex );
            }
        }
    }

}
