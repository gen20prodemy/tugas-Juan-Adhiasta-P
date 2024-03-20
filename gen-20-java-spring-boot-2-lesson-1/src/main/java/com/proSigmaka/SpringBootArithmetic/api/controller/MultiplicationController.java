package com.proSigmaka.SpringBootArithmetic.api.controller;

import com.proSigmaka.SpringBootArithmetic.api.model.Multiplication;
import com.proSigmaka.SpringBootArithmetic.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiplicationController {
    @Autowired
    private MultiplicationService multiplicationService;

    @PostMapping("/multi")
    public Multiplication multiplication(@RequestBody Multiplication multiplication){
        multiplicationService.setMultiplication(multiplication);
        return multiplicationService.getMultiplication();
    }
}
