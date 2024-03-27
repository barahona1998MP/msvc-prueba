package com.msvc.bike.repository;

import com.msvc.bike.entity.Bike;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Long> {
    List<Bike> findByUserId(Long userId);
}
