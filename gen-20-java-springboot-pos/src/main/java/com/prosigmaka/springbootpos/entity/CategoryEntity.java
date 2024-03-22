package com.prosigmaka.springbootpos.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "category", schema = "public", catalog = "PointOfSale")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "category_name", nullable = false)
    private String categoryName;
    @Column(name = "category_date", nullable = true)
    private Timestamp categoryDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Timestamp getCategoryDate() {
        return categoryDate;
    }

    public void setCategoryDate(Timestamp categoryDate) {
        this.categoryDate = categoryDate;
    }
}
