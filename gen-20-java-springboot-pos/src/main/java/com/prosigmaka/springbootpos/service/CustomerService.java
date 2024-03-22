package com.prosigmaka.springbootpos.service;

import com.prosigmaka.springbootpos.entity.CustomerEntity;
import com.prosigmaka.springbootpos.helper.GlobalHttpResponse;
import com.prosigmaka.springbootpos.model.CustomerModel;
import com.prosigmaka.springbootpos.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public GlobalHttpResponse<List<CustomerEntity>> getAll(){ //untuk mencari semuaa isi table customer order by age
        return new GlobalHttpResponse<>(200,"Success retrive data",customerRepo.findSortedCustomerByAge());
    }

    public GlobalHttpResponse<List<CustomerEntity>> getAllNative(){
        return new GlobalHttpResponse<>(200,"Success retrive data",customerRepo.findSortedCustomerByAgeNative());
    }


    public GlobalHttpResponse<List<CustomerEntity>> insetDataNative(CustomerModel customerModel){
        CustomerEntity newCustomer = customerModel.customerToEntity();
        customerRepo.insertCustomerNative(newCustomer.getFirstName(), newCustomer.getLastName(),
                newCustomer.getAddress(), newCustomer.getAge());
        return new GlobalHttpResponse<>(201,"Success insert data",customerRepo.findSortedCustomerByAge());
    }

}
