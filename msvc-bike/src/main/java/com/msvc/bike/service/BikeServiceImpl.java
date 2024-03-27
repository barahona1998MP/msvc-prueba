package com.msvc.bike.service;

import com.msvc.bike.entity.Bike;
import com.msvc.bike.repository.BikeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeServiceImpl implements BikeService{

    final BikeRepository bikeRepository;
    public BikeServiceImpl(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Override
    public Bike save(Bike bike) {
        return  bikeRepository.save(bike);
    }

    @Override
    public List<Bike> findAll() {
        return (List<Bike>) bikeRepository.findAll();
    }

    @Override
    public Bike findById(Long id) {
        return bikeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Bike> findByUserId(Long userId) {
        return bikeRepository.findByUserId(userId);
    }
}
