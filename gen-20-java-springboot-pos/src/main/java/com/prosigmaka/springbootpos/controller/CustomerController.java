package com.prosigmaka.springbootpos.controller;

import com.prosigmaka.springbootpos.entity.CustomerEntity;
import com.prosigmaka.springbootpos.helper.GlobalHttpResponse;
import com.prosigmaka.springbootpos.model.CustomerModel;
import com.prosigmaka.springbootpos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){this.customerService = customerService;}

    @GetMapping("/")
    public GlobalHttpResponse<List<CustomerEntity>> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/native")
    public GlobalHttpResponse<List<CustomerEntity>> getAllNative(){
        return customerService.getAllNative();
    }

    @PostMapping("/")
    public GlobalHttpResponse<List<CustomerEntity>> insertDataNative(@RequestBody CustomerModel customerModel){
        return customerService.insetDataNative(customerModel);
    }
}
