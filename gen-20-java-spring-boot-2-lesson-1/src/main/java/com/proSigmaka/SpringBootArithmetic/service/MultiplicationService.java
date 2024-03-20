package com.proSigmaka.SpringBootArithmetic.service;

import com.proSigmaka.SpringBootArithmetic.api.model.Multiplication;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {

    public Multiplication getMultiplication(Multiplication multiplication){
        Multiplication multi = new Multiplication();
        multi.setNumberA(multiplication.getNumberA());
        multi.setNumberB(multiplication.getNumberB());
        multi.getHasilKali();
        return multi;
    }
}
