package com.prosigmaka.springkafkademo.repo;

import com.prosigmaka.springkafkademo.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Integer> {
}
