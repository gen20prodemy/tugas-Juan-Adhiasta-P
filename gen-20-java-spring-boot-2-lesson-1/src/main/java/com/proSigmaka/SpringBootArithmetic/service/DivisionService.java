package com.proSigmaka.SpringBootArithmetic.service;

import com.proSigmaka.SpringBootArithmetic.api.model.Division;
import org.springframework.stereotype.Service;

@Service
public class DivisionService {
    public Division getDivision(Division division){
        Division div = new Division();
        div.setNumberA(division.getNumberA());
        div.setNumberB(division.getNumberB());
        div.setHasilBagi();
        return div;
    }
}
