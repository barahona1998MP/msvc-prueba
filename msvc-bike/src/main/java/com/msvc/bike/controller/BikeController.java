package com.msvc.bike.controller;

import com.msvc.bike.entity.Bike;
import com.msvc.bike.service.BikeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    final BikeService bikeService;

    public BikeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }


    @PostMapping
    public ResponseEntity<Bike> saveBike(@RequestBody @Valid Bike bike) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bikeService.save(bike));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bike>> findAllBike() {
        List<Bike> bikes = bikeService.findAll();
        if (bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> findByBikeId(@PathVariable Long id) {
        Bike bike = bikeService.findById(id);
        if (bike == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(bike);
    }

    @GetMapping("/byuser/{userId}")
    public ResponseEntity<List<Bike>> findByUserId(@PathVariable Long userId) {
        List<Bike> bikes = bikeService.findByUserId(userId);
        return ResponseEntity.ok(bikes);
    }


}
