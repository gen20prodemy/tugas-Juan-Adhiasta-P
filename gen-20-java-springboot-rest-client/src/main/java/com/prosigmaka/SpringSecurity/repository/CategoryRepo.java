package com.prosigmaka.SpringSecurity.repository;

import com.prosigmaka.SpringSecurity.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {
}
