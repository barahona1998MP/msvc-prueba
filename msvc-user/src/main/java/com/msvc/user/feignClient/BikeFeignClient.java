package com.msvc.user.feignClient;

import com.msvc.user.dto.BikeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-bike", url = "http://localhost:8082/bike")
public interface BikeFeignClient {

    @GetMapping("/byuser/{userId}")
    List<BikeDto> getBikes(@PathVariable Long userId);
}
