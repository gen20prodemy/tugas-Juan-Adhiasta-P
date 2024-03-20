package com.proSigmaka.SpringBootArithmetic.api.controller;

import com.proSigmaka.SpringBootArithmetic.api.model.Subtraction;
import com.proSigmaka.SpringBootArithmetic.service.SubtractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubtractionController {

    @Autowired
    private SubtractionService subtractionService;

    @PostMapping("/subtract")
    public Subtraction subtraction(@RequestBody Subtraction subtraction){
        subtractionService.setSubtraction(subtraction);
        return subtractionService.getSubtraction();
    }

}
