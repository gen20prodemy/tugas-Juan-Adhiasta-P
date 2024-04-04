package com.prosigmaka.SpringSecurity.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.prosigmaka.SpringSecurity.model.CategoryResponseModel;
import com.prosigmaka.SpringSecurity.model.ProductResponseModel;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
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

    public CategoryResponseModel entityToModel(){
        CategoryResponseModel category = new CategoryResponseModel();
        List<ProductResponseModel> product = new ArrayList<>();

        for(ProductEntity data : this.products){
            product.add(data.entityToModel());
        }
        category.setId(id);
        category.setName(categoryName);
        category.setProducts(product);
        return category;
    }
}
