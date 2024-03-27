package com.msvc.car.msvccar.services;

import com.msvc.car.msvccar.entity.Car;

import java.util.List;

public interface CarService {

    Car save(Car car);

    List<Car> findAll();

    List<Car> findByUserId(Long userId);


}
