package com.msvc.user.feignClient;

import com.msvc.user.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-car", url = "http://localhost:8081/car")
public interface CarFeignClient {

    @GetMapping("/byuser/{userId}")
    List<CarDto> getCars(@PathVariable Long userId);

}
