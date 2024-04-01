package com.prosigmaka.SpringSecurity.model;

import com.prosigmaka.SpringSecurity.entity.CategoryEntity;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class CategoryModel {

    private String name;

    public CategoryEntity toEntity(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(name);
        categoryEntity.setCategoryDate(new Timestamp(System.currentTimeMillis()));
        return categoryEntity;
    }
}
