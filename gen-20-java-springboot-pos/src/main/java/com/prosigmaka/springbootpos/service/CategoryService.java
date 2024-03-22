package com.prosigmaka.springbootpos.service;

import com.prosigmaka.springbootpos.entity.CategoryEntity;
import com.prosigmaka.springbootpos.helper.GlobalHttpResponse;
import com.prosigmaka.springbootpos.model.CategoryModel;
import com.prosigmaka.springbootpos.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {


    private CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public GlobalHttpResponse<List<CategoryEntity>> getAll(){
        return new GlobalHttpResponse<>(200,"Success retrive data from database",categoryRepo.findAll());
    }

    public GlobalHttpResponse<Optional<CategoryEntity>> getById(int id){
        Optional<CategoryEntity> searchId = categoryRepo.findById(id);
        if(searchId.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",searchId);
        } else {
            return new GlobalHttpResponse<>(200,"Data retrive success", searchId);
        }
    }

    public GlobalHttpResponse<CategoryEntity> insertData(CategoryModel categoryModel){
        return new GlobalHttpResponse<>(201,"Success insert data",categoryRepo.save(categoryModel.toEntity()));
    }

    public GlobalHttpResponse<CategoryEntity> updateById(int id, CategoryModel categoryModel){
        Optional<CategoryEntity> findId = categoryRepo.findById(id);
        if(findId.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",new CategoryEntity());
        } else {
            CategoryEntity categoryEntity = findId.get();
            categoryEntity.setCategoryName(categoryModel.getName());
            categoryEntity.setCategoryDate(new Timestamp(System.currentTimeMillis()));
            return new GlobalHttpResponse<>(200,"Success update",categoryRepo.save(categoryEntity));
        }
    }

    public GlobalHttpResponse<CategoryEntity> deleteById(int id, CategoryModel categoryModel) {
        Optional<CategoryEntity> seekId = categoryRepo.findById(id);
        if(seekId.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",new CategoryEntity());
        } else {
            CategoryEntity categoryEntity = seekId.get();
            categoryRepo.deleteById(id);
            return new GlobalHttpResponse<>(200,"Data deleted",categoryEntity);
        }
    }
}
