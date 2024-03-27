package com.msvc.user.services;

import com.msvc.user.dto.BikeDto;
import com.msvc.user.dto.CarDto;
import com.msvc.user.entity.User;
import com.msvc.user.feignClient.BikeFeignClient;
import com.msvc.user.feignClient.CarFeignClient;
import com.msvc.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    final UserRepository userRepository;
    final CarFeignClient carFeignClient;
    final BikeFeignClient bikeFeignClient;

    public UserServiceImpl(UserRepository userRepository, CarFeignClient carFeignClient, BikeFeignClient bikeFeignClient) {
        this.userRepository = userRepository;
        this.carFeignClient = carFeignClient;
        this.bikeFeignClient = bikeFeignClient;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<CarDto> getCars(Long userId) {
        return (List<CarDto>) carFeignClient.getCars(userId);
    }

    @Override
    public List<BikeDto> getBikes(Long userId) {
        return (List<BikeDto>) bikeFeignClient.getBikes(userId);
    }

    @Override
    public Map<String, Object> getUserAndVehicles(Long userId) {
        Map<String, Object> result = new HashMap<>();
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            result.put("Message", "Usuario no existe");
            return result;
        }
        result.put("User", user);

        List<CarDto> cars = carFeignClient.getCars(userId);
        if (cars.isEmpty())
            result.put("Cars", "Este usuario no tiene coches");
        else
            result.put("Cars", cars);

        List<BikeDto> bikes = bikeFeignClient.getBikes(userId);
        if (bikes.isEmpty())
            result.put("Bikes", "Este usuario no tiene motos");
        else
            result.put("Bikes", bikes);

        return result;
    }
}
