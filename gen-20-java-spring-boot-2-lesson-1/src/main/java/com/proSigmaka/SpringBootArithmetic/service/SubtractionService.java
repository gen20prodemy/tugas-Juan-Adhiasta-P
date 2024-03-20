package com.proSigmaka.SpringBootArithmetic.service;

import com.proSigmaka.SpringBootArithmetic.api.model.Subtraction;
import org.springframework.stereotype.Service;

@Service
public class SubtractionService {
    public Subtraction getSubtraction(Subtraction subtraction){
        Subtraction sub = new Subtraction();
        sub.setNumberA(subtraction.getNumberA());
        sub.setNumberB(subtraction.getNumberB());
        sub.setHasilKurang();
        return sub;
    }
}
