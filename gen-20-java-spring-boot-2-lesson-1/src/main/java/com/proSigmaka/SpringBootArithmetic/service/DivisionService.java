package com.proSigmaka.SpringBootArithmetic.service;

import com.proSigmaka.SpringBootArithmetic.api.model.Division;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {
    private Division division;

    public DivisionService(){
        this.division = new Division();
    }

    public Division getDivision(){
        return division;
    }

    public void setDivision(Division division){
        this.division.setNumberA(division.getNumberA());
        this.division.setNumberB(division.getNumberB());
        this.division.setHasilBagi();
    }
}
