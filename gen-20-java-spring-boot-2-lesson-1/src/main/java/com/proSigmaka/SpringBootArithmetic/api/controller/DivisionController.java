package com.proSigmaka.SpringBootArithmetic.api.controller;

import com.proSigmaka.SpringBootArithmetic.api.model.Division;
import com.proSigmaka.SpringBootArithmetic.service.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DivisionController {
    @Autowired
    private DivisionService divisionService;

    @PostMapping("/bagi")
    public Division division(@RequestBody Division division){
        return divisionService.getDivision(division);
    }
}
