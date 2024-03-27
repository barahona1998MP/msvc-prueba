package com.msvc.user.services;

import com.msvc.user.dto.BikeDto;
import com.msvc.user.dto.CarDto;
import com.msvc.user.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findById(Long id);

    List<CarDto> getCars(Long userId);

    List<BikeDto> getBikes(Long userId);

    Map<String, Object> getUserAndVehicles(Long userId);
}
