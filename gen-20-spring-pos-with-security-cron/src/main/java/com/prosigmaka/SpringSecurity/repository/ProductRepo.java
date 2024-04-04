package com.prosigmaka.SpringSecurity.repository;

import com.prosigmaka.SpringSecurity.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
}
