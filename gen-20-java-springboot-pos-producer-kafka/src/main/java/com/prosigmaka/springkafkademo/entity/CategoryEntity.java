package com.prosigmaka.springkafkademo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prosigmaka.springkafkademo.dto.CategoryResponseDto;
import com.prosigmaka.springkafkademo.dto.ProductResponseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category", schema = "public", catalog = "PointOfSale")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "category_name", nullable = false)
    private String categoryName;
    @OneToMany(mappedBy = "categoryId")
    @JsonManagedReference
    private List<ProductEntity> products;
    @Column(name = "category_date")
    private Timestamp categoryDate;

    public CategoryResponseDto entityToDto(){
        CategoryResponseDto category = new CategoryResponseDto();
        List<ProductResponseDto> product = new ArrayList<>();

        for(ProductEntity data : this.products){
            product.add(data.entityToDto());
        }
        category.setId(id);
        category.setName(categoryName);
        category.setProducts(product);
        return category;
    }
}
