package com.prosigmaka.springkafkademo.dto;

import com.prosigmaka.springkafkademo.entity.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    private String name;

    public CategoryEntity dtoToEntity(){
        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(name);
        category.setCategoryDate(new Timestamp(System.currentTimeMillis()));
        return category;
    }
}
