package com.proSigmaka.SpringBootArithmetic.service;

import com.proSigmaka.SpringBootArithmetic.api.model.Addition;
import org.springframework.stereotype.Service;

@Service
public class AdditionService {

    private Addition addition;

    public AdditionService(){
        addition = new Addition();
    }

    public Addition getAddition(){
        return addition;
    }

    public void setAddition(Addition addition){
        this.addition.setNumberA(addition.getNumberA());
        this.addition.setNumberB(addition.getNumberB());
        this.addition.setHasilTambah();
    }
}
