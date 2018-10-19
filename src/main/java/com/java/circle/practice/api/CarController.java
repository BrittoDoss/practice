package com.java.circle.practice.api;

import com.java.circle.practice.api.model.Car;
import com.java.circle.practice.api.repository.CarRepository;
import com.java.circle.practice.api.service.CarService;
import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@SwaggerDefinition
@Api(value = "Car Controller APIs")
public class CarController {

    private CarService carService;
    private CarRepository carRepository;

    @ApiOperation(value = "Get Car details based on the License Plate")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST")
    })
    @GetMapping("/v1/car/{licencePlate}")
    public Car loadMetadata(@PathVariable String licencePlate) {
        return carService.getCar ( licencePlate );
    }
}
