package com.springboot.javaspringlesson1.api.controller;

import com.springboot.javaspringlesson1.api.model.Hello;
import com.springboot.javaspringlesson1.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //for API
public class HelloController {

    //@Autowired
    private HelloService helloService;

    @Autowired //dependency injection into constructor
    public HelloController(HelloService helloService){
        this.helloService = helloService;
    }

    @GetMapping("/") //Get Request
    public Hello getHello(){
        return helloService.getHello();
    }
}
