package com.proSigmaka.SpringBootArithmetic.api.model;

public class Multiplication {
    private float numberA;
    private float numberB;
    private float hasilKali;

    public Multiplication(){

    }
    public Multiplication(float numberA, float numberB){
        this.numberA = numberA;
        this.numberB = numberB;
    }

    public float getNumberA(){
        return numberA;
    }

    public void setNumberA(float numberA){
        this.numberA = numberA;
    }

    public float getNumberB(){
        return numberB;
    }

    public void setNumberB(float numberB){
        this.numberB = numberB;
    }

    public float getHasilKali(){
        return hasilKali;
    }

    public void setHasilKali(){
        this.hasilKali = numberA*numberB;
    }
}
