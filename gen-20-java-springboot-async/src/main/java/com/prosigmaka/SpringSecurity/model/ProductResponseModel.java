package com.prosigmaka.SpringSecurity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseModel {
    private int id;
    private String prodName;
    private int price;
    private int quantity;
    private CategoryModel categoryModel;
}
