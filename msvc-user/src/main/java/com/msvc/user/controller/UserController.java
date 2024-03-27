package com.msvc.user.controller;

import com.msvc.user.dto.BikeDto;
import com.msvc.user.dto.CarDto;
import com.msvc.user.entity.User;
import com.msvc.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody @Valid User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAllUser() {
        List<User> users = userService.findAll();
        if (users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        var user = userService.findById(id);
        if (user == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/car/{userId}")
    public ResponseEntity<List<CarDto>> getCars(@PathVariable Long userId) {
        User user = userService.findById(userId);
        if (user == null)
            return ResponseEntity.notFound().build();
        List<CarDto> cars = userService.getCars(userId);
        if (cars.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/bike/{userId}")
    public ResponseEntity<List<BikeDto>> getBikes(@PathVariable Long userId){
        User user = userService.findById(userId);
        if (user == null)
            return ResponseEntity.notFound().build();
        List<BikeDto> bikes = userService.getBikes(userId);
        if (bikes.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(bikes);
    }

    @GetMapping("/getAll/{userId}")
    public ResponseEntity<Map<String, Object>> getAllVehicle(@PathVariable Long userId) {
        Map<String, Object> result = userService.getUserAndVehicles(userId);
        return ResponseEntity.ok(result);
    }
}
