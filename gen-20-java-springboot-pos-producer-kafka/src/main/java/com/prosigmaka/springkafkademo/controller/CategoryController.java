package com.prosigmaka.springkafkademo.controller;

import com.prosigmaka.springkafkademo.dto.CategoryDto;
import com.prosigmaka.springkafkademo.entity.CategoryEntity;
import com.prosigmaka.springkafkademo.helper.GlobalHttpResponse;
import com.prosigmaka.springkafkademo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
@CacheConfig(cacheNames = "category") //centralizing some configuration
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    @GetMapping("/")
    public GlobalHttpResponse<List<CategoryEntity>> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public GlobalHttpResponse<CategoryEntity> getById(@PathVariable("id") int id){
        return categoryService.getById(id);
    }
    @PostMapping("/")
    public GlobalHttpResponse<CategoryEntity> insertData(@RequestBody CategoryDto categoryModel){
        return categoryService.create(categoryModel);
    }

    @PostMapping("/publish")
    public String message(@RequestBody CategoryDto categoryDto){
        kafkaTemplate.send("createAnother",categoryDto);
        return "New category published to broker";
    }
    @PutMapping("/{id}")
    public GlobalHttpResponse<CategoryEntity> updateById(@PathVariable("id")int id,
                                                         @RequestBody CategoryDto categoryModel){
        return categoryService.updateById(id, categoryModel);
    }
    @DeleteMapping("/{id}")
    public GlobalHttpResponse<CategoryEntity> deleteById(@PathVariable("id") int id){
        return categoryService.deleteById(id);
    }
}
