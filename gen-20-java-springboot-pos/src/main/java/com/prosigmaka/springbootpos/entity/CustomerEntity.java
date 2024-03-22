package com.prosigmaka.springbootpos.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity(name = "customer")
@Table(name = "customer", schema = "public", catalog = "PointOfSale")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int Id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "customer_date")
    private Timestamp customerDate;
    @Column(name = "age", nullable = false)
    private int age;

    public int getAge(){return age;}

    public void setAge(int age){this.age = age;}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public Timestamp getCustomerDate() {
        return customerDate;
    }

    public void setCustomerDate(Timestamp customerDate) {
        this.customerDate = customerDate;
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
}
