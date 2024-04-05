package com.prosigmaka.springkafkademo.service;

import com.prosigmaka.springkafkademo.dto.ProductDto;
import com.prosigmaka.springkafkademo.dto.ProductResponseDto;
import com.prosigmaka.springkafkademo.entity.CategoryEntity;
import com.prosigmaka.springkafkademo.entity.ProductEntity;
import com.prosigmaka.springkafkademo.helper.GlobalHttpResponse;
import com.prosigmaka.springkafkademo.repo.CategoryRepo;
import com.prosigmaka.springkafkademo.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public GlobalHttpResponse<List<ProductResponseDto>> getAll(){
        List<ProductEntity> products = productRepo.findAll();
        List<ProductResponseDto> result = new ArrayList<>();
        for(ProductEntity data : products){
            result.add(data.entityToDto());
        }
        return new GlobalHttpResponse<>(200,"Success retrive data",result);
    }

    public GlobalHttpResponse<ProductResponseDto> getById(int id){
        Optional<ProductEntity> product = productRepo.findById(id);
        if(product.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",product.get().entityToDto());
        } else {
            return new GlobalHttpResponse<>(200,"Success retrive data",product.get().entityToDto());
        }
    }

    public GlobalHttpResponse<ProductResponseDto> insert(ProductDto productModel){
        ProductEntity product = productModel.dtoToEntity();
        CategoryEntity category = categoryRepo.findById(productModel.getCategoryId()).orElse(null);
        if(category == null){
            return new GlobalHttpResponse<>(404,"Data not found",new ProductEntity().entityToDto());
        } else {
            product.setCategoryId(category);
            ProductEntity result = productRepo.save(product);
            return new GlobalHttpResponse<>(201,"Data created",result.entityToDto());
        }
    }

    public GlobalHttpResponse<ProductResponseDto> updateById(int id, ProductDto productModel){
        Optional<ProductEntity> product = productRepo.findById(id);
        if(product.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",new ProductEntity().entityToDto());
        }
        CategoryEntity category = categoryRepo.findById(productModel.getCategoryId()).orElse(null);
        if(category == null){
            return new GlobalHttpResponse<>(404,"Data not found",new ProductEntity().entityToDto());
        }
        ProductEntity productEntity = product.get();
        productEntity.setProdName(productModel.getName());
        productEntity.setPrice(productModel.getPrice());
        productEntity.setCategoryId(category);
        productEntity.setQuantity(productModel.getQuantity());
        ProductEntity result = productRepo.save(productEntity);
        return new GlobalHttpResponse<>(200,"Success update data",result.entityToDto());
    }

    public GlobalHttpResponse<ProductResponseDto> deleteById(int id){
        Optional<ProductEntity> product = productRepo.findById(id);
        if(product.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",new ProductEntity().entityToDto());
        }
        ProductEntity productEntity = product.get();
        productRepo.deleteById(id);
        return new GlobalHttpResponse<>(200,"Data deleted",productEntity.entityToDto());
    }
}

