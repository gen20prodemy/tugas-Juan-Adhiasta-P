package com.prosigmaka.springbootpos.model;

import com.prosigmaka.springbootpos.entity.CustomerEntity;

import java.sql.Timestamp;

public class CustomerModel {
    private String firstName;
    private String lastName;
    private String address;
    private int age;

    public CustomerEntity customerToEntity(){
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(firstName);
        customerEntity.setLastName(lastName);
        customerEntity.setAddress(address);
        customerEntity.setAge(age);
        customerEntity.setCustomerDate(new Timestamp(System.currentTimeMillis()));
        return customerEntity;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
