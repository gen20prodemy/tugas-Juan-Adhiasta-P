package com.prosigmaka.springkafkademo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prosigmaka.springkafkademo.dto.CategoryDto;
import com.prosigmaka.springkafkademo.dto.ProductResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product", schema = "public", catalog = "PointOfSale")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "prod_name", nullable = false)
    private String prodName;
    @Column(name = "price",nullable = false)
    private int price;
    @Column(name = "quantity",nullable = false)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private CategoryEntity categoryId;

    public ProductResponseDto entityToDto(){
        ProductResponseDto product = new ProductResponseDto();
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(categoryId.getCategoryName());

        product.setId(id);
        product.setName(prodName);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategoryDto(categoryDto);
        return product;
    }
}
