package com.prosigmaka.springkafkademo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryResponseDto {

    private int id;
    private String name;
    private List<ProductResponseDto> products;
}
