package com.msvc.car.msvccar.repository;

import com.msvc.car.msvccar.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByUserId(Long userId);
}
