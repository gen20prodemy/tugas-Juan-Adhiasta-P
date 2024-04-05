package com.prosigmaka.springkafkademo.dto;

import com.prosigmaka.springkafkademo.entity.CategoryEntity;
import com.prosigmaka.springkafkademo.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private int price;
    private int quantity;
    private int categoryId;

    public ProductEntity dtoToEntity(){
        ProductEntity product = new ProductEntity();
        CategoryEntity category = new CategoryEntity();
        category.setId(categoryId);

        product.setProdName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        return product;
    }
}
