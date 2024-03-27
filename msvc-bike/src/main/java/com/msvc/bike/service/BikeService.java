package com.msvc.bike.service;

import com.msvc.bike.entity.Bike;

import java.util.List;

public interface BikeService {

    Bike save(Bike bike);

    List<Bike> findAll();

    Bike findById(Long id);

    List<Bike> findByUserId(Long userId);

}
