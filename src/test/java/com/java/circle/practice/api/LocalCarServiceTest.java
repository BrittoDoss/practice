package com.java.circle.practice.api;

import com.java.circle.practice.api.exception.CarException;
import com.java.circle.practice.api.model.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LocalCarServiceTest {

    @InjectMocks
    private LocalCarService localCarService;

    private Car expectedCar;

    @Before
    public void setUp() throws Exception {
        expectedCar = new Car();
        expectedCar.setBrand("BMW");
        expectedCar.setConsumption(10);
        expectedCar.setLicensePlate("ABC-123");
    }

    @Test
    public void shouldReturnLicencePlate() {
        Car actualCar = localCarService.getCar("ABC-123");

        assertEquals(expectedCar, actualCar);
    }

    @Test(expected = CarException.class)
    public void shouldThrowException_whenLicencePlateIsTooLong() {
        localCarService.getCar("ABC-1233333333");
    }
}