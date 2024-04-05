package com.prosigmaka.springkafkademo.service;

import com.prosigmaka.springkafkademo.dto.CategoryDto;
import com.prosigmaka.springkafkademo.entity.CategoryEntity;
import com.prosigmaka.springkafkademo.helper.GlobalHttpResponse;
import com.prosigmaka.springkafkademo.repo.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public GlobalHttpResponse<List<CategoryEntity>> getAll(){
        return new GlobalHttpResponse<>(200,"Data retrive", categoryRepo.findAll());
    }

    public GlobalHttpResponse<CategoryEntity> getById(int id){
        CategoryEntity findId = new CategoryEntity();
        Optional<CategoryEntity> searchId = categoryRepo.findById(id);
        if(searchId.isPresent()){
            findId = searchId.get();
            return new GlobalHttpResponse<>(200,"Data retrive",findId);
        }
        return new GlobalHttpResponse<>(404,"Data not found", findId);
    }

    public GlobalHttpResponse<CategoryEntity> create(CategoryDto categoryDto){
        var insertDto = categoryDto.dtoToEntity();
        CategoryEntity category = categoryRepo.save(insertDto);
        return new GlobalHttpResponse<>(201, "Success create data", category);
    }

    public GlobalHttpResponse<CategoryEntity> updateById(int id, CategoryDto categoryDto){
        Optional<CategoryEntity> findId = categoryRepo.findById(id);
        if(findId.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",new CategoryEntity());
        } else {
            CategoryEntity category = findId.get();
            category.setCategoryName(categoryDto.getName());
            category.setCategoryDate(new Timestamp(System.currentTimeMillis()));
            CategoryEntity update = categoryRepo.save(category);
            return new GlobalHttpResponse<>(200,"Success update data",update);
        }
    }

    public GlobalHttpResponse<CategoryEntity> deleteById(int id){
        Optional<CategoryEntity> searchId = categoryRepo.findById(id);
        if(searchId.isEmpty()){
            return new GlobalHttpResponse<>(404,"Data not found",new CategoryEntity());
        } else {
            CategoryEntity category = searchId.get();
            categoryRepo.deleteById(id);
            return new GlobalHttpResponse<>(200,"Data deleted",category);
        }
    }
    @KafkaListener(topics = "createAnother", groupId = "pos-group")
    public void listen(CategoryDto categoryDto){
        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(categoryDto.getName());
        category.setCategoryDate(new Timestamp(System.currentTimeMillis()));
        //categoryRepo.save(category); //making error in listener cause continuously get from broker
        System.out.println("User data saved from Kafka Listener!");
    }
}
