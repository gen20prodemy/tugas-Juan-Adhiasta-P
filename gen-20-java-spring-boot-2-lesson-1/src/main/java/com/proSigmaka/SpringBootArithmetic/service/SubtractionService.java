package com.proSigmaka.SpringBootArithmetic.service;

import com.proSigmaka.SpringBootArithmetic.api.model.Subtraction;
import org.springframework.stereotype.Service;

@Service
public class SubtractionService {
    private Subtraction subtraction;

    public SubtractionService(){
        this.subtraction = new Subtraction();
    }
    public Subtraction getSubtraction(){
        return subtraction;
    }
    public void setSubtraction(Subtraction subtraction){
        this.subtraction.setNumberA(subtraction.getNumberA());
        this.subtraction.setNumberB(subtraction.getNumberB());
        this.subtraction.setHasilKurang();
    }
}
