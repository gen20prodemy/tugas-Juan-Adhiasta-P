package com.prosigmaka.springkafkademo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private int id;
    private String name;
    private int price;
    private int quantity;
    private CategoryDto categoryDto;
}
