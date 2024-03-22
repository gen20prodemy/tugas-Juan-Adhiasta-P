package com.prosigmaka.springbootpos.repository;

import com.prosigmaka.springbootpos.entity.CustomerEntity;
import com.prosigmaka.springbootpos.model.CustomerModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {
    @Query("SELECT t FROM customer t ORDER BY age")
    List<CustomerEntity> findSortedCustomerByAge();

    @Query(nativeQuery = true, value="SELECT * FROM customer ORDER BY age")
    List<CustomerEntity> findSortedCustomerByAgeNative();

    @Modifying
    @Transactional
    @Query(value="INSERT INTO customer (first_name, last_name, address, age)" +
            "VALUES (:firstName, :lastName, :address, :age)", nativeQuery = true)
    void insertCustomerNative(String firstName, String lastName, String address, int age);
}
