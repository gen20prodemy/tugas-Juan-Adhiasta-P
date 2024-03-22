package com.prosigmaka.springbootpos.model;

import com.prosigmaka.springbootpos.entity.CategoryEntity;
import org.springframework.validation.annotation.Validated;

import java.sql.Timestamp;

public class CategoryModel {
    private String name;

    public CategoryEntity toEntity(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(name);
        categoryEntity.setCategoryDate(new Timestamp(System.currentTimeMillis()));
        return categoryEntity;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
