package com.proSigmaka.SpringBootArithmetic.api.model;

import com.proSigmaka.SpringBootArithmetic.service.AdditionService;

public class Addition {
    private float numberA;
    private float numberB;
    private float hasilTambah;
    public Addition(){

    }

    public Addition(float numberA, float numberB){
        this.numberA = numberA;
        this.numberB = numberB;
    }
    public float getNumberA() {
        return numberA;
    }

    public void setNumberA(float numberA) {
        this.numberA = numberA;
    }

    public float getNumberB() {
        return numberB;
    }

    public void setNumberB(Float numberB) {
        this.numberB = numberB;
    }

    public float getHasilTambah(){
        return hasilTambah;
    }

    public void setHasilTambah(){
        this.hasilTambah = numberA+numberB;
    }
}
