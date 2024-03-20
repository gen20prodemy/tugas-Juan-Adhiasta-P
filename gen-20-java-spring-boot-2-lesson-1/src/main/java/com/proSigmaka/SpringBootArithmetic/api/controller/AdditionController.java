package com.proSigmaka.SpringBootArithmetic.api.controller;

import com.proSigmaka.SpringBootArithmetic.api.model.Addition;
import com.proSigmaka.SpringBootArithmetic.service.AdditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AdditionController {
    @Autowired
    private AdditionService additionService;

    @PostMapping("/tambah")
    public Addition addition(@RequestBody Addition addition){
        additionService.setAddition(addition);
        return additionService.getAddition();
    }


}
