package com.proSigmaka.SpringBootArithmetic.api.model;

public class Subtraction {
    private float numberA;
    private float numberB;
    private float hasilKurang;

    public Subtraction(){

    }
    public Subtraction(float numberA, float numberB){
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

    public void setNumberB(float numberB) {
        this.numberB = numberB;
    }

    public float getHasilKurang() {
        return hasilKurang;
    }

    public void setHasilKurang() {
        this.hasilKurang = numberA - numberB;
    }
}
