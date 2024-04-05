package com.prosigmaka.SpringSecurity.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.prosigmaka.SpringSecurity.model.CategoryModel;
import com.prosigmaka.SpringSecurity.model.ProductResponseModel;
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

    public ProductResponseModel entityToModel(){
        ProductResponseModel product = new ProductResponseModel();
        CategoryModel categories = new CategoryModel();
        categories.setName(categoryId.getCategoryName());

        product.setId(id);
        product.setProdName(prodName);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategoryModel(categories);
        return product;
    }

}
