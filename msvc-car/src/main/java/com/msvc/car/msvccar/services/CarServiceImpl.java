package com.msvc.car.msvccar.services;

import com.msvc.car.msvccar.entity.Car;
import com.msvc.car.msvccar.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService{

    final CarRepository carRepository;
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> findAll() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public List<Car> findByUserId(Long userId) {
        return carRepository.findByUserId(userId);
    }
}
