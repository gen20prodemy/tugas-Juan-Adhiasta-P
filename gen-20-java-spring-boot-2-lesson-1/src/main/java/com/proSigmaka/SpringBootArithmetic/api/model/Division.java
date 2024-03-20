package com.proSigmaka.SpringBootArithmetic.api.model;

public class Division {
    private float numberA;
    private float numberB;
    private double hasilBagi;

    public Division(){

    }
    public Division(float numberA,float numberB){
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

    public double getHasilBagi() {
        return hasilBagi;
    }

    public void setHasilBagi() {
        this.hasilBagi = (double) numberA/numberB;
    }
}
