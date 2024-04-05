package com.prosigmaka.SpringSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseModel {
    private int id;
    private String name;
    private List<ProductResponseModel> products;
}
