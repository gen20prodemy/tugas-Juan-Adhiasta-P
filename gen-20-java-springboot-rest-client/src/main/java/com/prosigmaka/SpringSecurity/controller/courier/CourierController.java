package com.prosigmaka.SpringSecurity.controller.courier;

import com.prosigmaka.SpringSecurity.model.courier.CourierCity;
import com.prosigmaka.SpringSecurity.model.courier.CourierCost;
import com.prosigmaka.SpringSecurity.model.courier.CourierProvince;
import com.prosigmaka.SpringSecurity.service.courier.CourierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courier")
@RequiredArgsConstructor
public class CourierController {

    private final CourierService courierService;

    @GetMapping("/province")
    public List<CourierProvince> findAll(){
        return courierService.findAll();
    }

    @GetMapping("/province/{id}")
    public CourierProvince findProvinceById(@PathVariable("id") String id){
        return courierService.findProvinceById(id);
    }

    @GetMapping("/city")
    public List<CourierCity> findAllCity(){
        return courierService.findAllCity();
    }

    @GetMapping("/city/{id}")
    public CourierCity findCityById(@PathVariable("id") String id){
        return courierService.findCityById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourierCost findCost(@RequestPart CourierCost courierCost){
        return courierService.findCost(courierCost);
    }
}
