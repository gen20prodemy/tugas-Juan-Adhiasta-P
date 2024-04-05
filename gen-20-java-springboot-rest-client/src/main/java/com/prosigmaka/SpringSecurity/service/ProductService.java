package com.prosigmaka.SpringSecurity.service;

import com.prosigmaka.SpringSecurity.entity.CategoryEntity;
import com.prosigmaka.SpringSecurity.entity.ProductEntity;
import com.prosigmaka.SpringSecurity.helper.GlobalHttpResponse;
import com.prosigmaka.SpringSecurity.model.ProductModel;
import com.prosigmaka.SpringSecurity.model.ProductResponseModel;
import com.prosigmaka.SpringSecurity.repository.CategoryRepo;
import com.prosigmaka.SpringSecurity.repository.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;

    public GlobalHttpResponse<List<ProductResponseModel>> getAll(){
        List<ProductEntity> products = productRepo.findAll();
        List<ProductResponseModel> result = new ArrayList<>();
        for(ProductEntity data : products){
            result.add(data.entityToModel());
        }
        return new GlobalHttpResponse<>(200,"Success retrive data",result);
    }

    public GlobalHttpResponse<ProductResponseModel> getById(int id){
        Optional<ProductEntity> product = productRepo.findById(id);
        if(product.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",product.get().entityToModel());
        } else {
            return new GlobalHttpResponse<>(200,"Success retrive data",product.get().entityToModel());
        }
    }

    public GlobalHttpResponse<ProductResponseModel> insert(ProductModel productModel){
        ProductEntity product = productModel.toEntity();
        CategoryEntity category = categoryRepo.findById(productModel.getCategoryId()).orElse(null);
        if(category == null){
            return new GlobalHttpResponse<>(404,"Data not found",new ProductEntity().entityToModel());
        } else {
            product.setCategoryId(category);
            ProductEntity result = productRepo.save(product);
            return new GlobalHttpResponse<>(201,"Data created",result.entityToModel());
        }
    }

    public GlobalHttpResponse<ProductResponseModel> updateById(int id, ProductModel productModel){
        Optional<ProductEntity> product = productRepo.findById(id);
        if(product.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",new ProductEntity().entityToModel());
        }
        CategoryEntity category = categoryRepo.findById(productModel.getCategoryId()).orElse(null);
        if(category == null){
            return new GlobalHttpResponse<>(404,"Data not found",new ProductEntity().entityToModel());
        }
        ProductEntity productEntity = product.get();
        productEntity.setProdName(productModel.getProdName());
        productEntity.setPrice(productModel.getPrice());
        productEntity.setCategoryId(category);
        productEntity.setQuantity(productModel.getQuantity());
        ProductEntity result = productRepo.save(productEntity);
        return new GlobalHttpResponse<>(200,"Success update data",result.entityToModel());
    }

    public GlobalHttpResponse<ProductResponseModel> deleteById(int id){
        Optional<ProductEntity> product = productRepo.findById(id);
        if(product.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",new ProductEntity().entityToModel());
        }
        ProductEntity productEntity = product.get();
        productRepo.deleteById(id);
        return new GlobalHttpResponse<>(200,"Data deleted",productEntity.entityToModel());
    }
}
