package com.springboot.javaspringlesson1.api.model;

public class Hello {

    private String hello;

    public Hello(){
        hello = "ini adalah awal Hello World!";
    }

    public String getHello(){
        return hello;
    }

    public void setHello(String hello){
        this.hello = hello;
    }

}
