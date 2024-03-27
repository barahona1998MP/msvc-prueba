package com.msvc.car.msvccar.controller;

import com.msvc.car.msvccar.entity.Car;
import com.msvc.car.msvccar.services.CarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody @Valid Car car) {
        return ResponseEntity.status(HttpStatus.CREATED).body(carService.save(car));
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAllCar() {
        List<Car> cars = carService.findAll();
        if (cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Car>> findCarByUserId(@PathVariable Long userId) {
        List<Car> cars = carService.findByUserId(userId);
        return ResponseEntity.ok(cars);
    }


}
