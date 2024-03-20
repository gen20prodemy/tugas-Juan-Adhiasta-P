package com.proSigmaka.SpringBootArithmetic.service;

import com.proSigmaka.SpringBootArithmetic.api.model.Multiplication;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationService {

    private Multiplication multiplication;

    public MultiplicationService(){
        this.multiplication = new Multiplication();
    }

    public Multiplication getMultiplication(){
        return multiplication;
    }

    public void setMultiplication(Multiplication multiplication){
        this.multiplication.setNumberA(multiplication.getNumberA());
        this.multiplication.setNumberB(multiplication.getNumberB());
        this.multiplication.setHasilKali();
    }
}
