package com.springboot.javaspringlesson1.service;

import com.springboot.javaspringlesson1.api.model.Hello;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    private Hello hello;

    public HelloService(){
        hello = new Hello();
    }

    public Hello getHello() {
        return hello;
    }
}
