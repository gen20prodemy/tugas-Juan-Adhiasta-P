package com.prosigmaka.SpringSecurity.model;

import com.prosigmaka.SpringSecurity.entity.CategoryEntity;
import com.prosigmaka.SpringSecurity.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    private String prodName;
    private int price;
    private int quantity;
    private int categoryId;

    public ProductEntity toEntity(){
        ProductEntity product = new ProductEntity();
        CategoryEntity category = new CategoryEntity();
        category.setId(categoryId);

        product.setProdName(prodName);
        product.setPrice(price);
        product.setQuantity(quantity);
        return product;
    }
}
