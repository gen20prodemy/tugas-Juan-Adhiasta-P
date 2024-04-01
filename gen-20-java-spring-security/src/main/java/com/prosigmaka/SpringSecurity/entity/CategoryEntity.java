package com.prosigmaka.SpringSecurity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;

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
    @Column(name = "category_date")
    private Timestamp categoryDate;
}
