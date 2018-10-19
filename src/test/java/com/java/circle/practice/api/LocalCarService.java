package com.java.circle.practice.api;

import com.java.circle.practice.api.exception.CarException;
import com.java.circle.practice.api.model.Car;
import com.java.circle.practice.api.service.CarService;

public class LocalCarService implements CarService {

    @Override
    public Car getCar(String licensePlate) {
        if (licensePlate.length () > 7) {
            throw new CarException (  "Bad licence plate format!" );
        }
        Car expectedCar = new Car ();
        expectedCar.setBrand("BMW");
        expectedCar.setConsumption(10);
        expectedCar.setLicensePlate(licensePlate);
        return expectedCar;
    }
}
