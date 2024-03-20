package com.proSigmaka.SpringBootArithmetic.service;

import com.proSigmaka.SpringBootArithmetic.api.model.Addition;
import org.springframework.stereotype.Service;

@Service
public class AdditionService {

    public Addition getAddition(Addition addition){
        Addition add = new Addition(); //karena di dalam getAddition, baru dipanggil ketika getAddition terpanggil
        add.setNumberA(addition.getNumberA());
        add.setNumberB(addition.getNumberB());
        add.setHasilTambah();
        return add;
    }
}
