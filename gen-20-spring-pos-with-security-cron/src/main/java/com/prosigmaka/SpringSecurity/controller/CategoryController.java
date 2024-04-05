package com.prosigmaka.SpringSecurity.controller;

import com.prosigmaka.SpringSecurity.entity.CategoryEntity;
import com.prosigmaka.SpringSecurity.helper.GlobalHttpResponse;
import com.prosigmaka.SpringSecurity.model.CategoryModel;
import com.prosigmaka.SpringSecurity.service.CategoryService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
@CacheConfig(cacheNames = "category") //centralizing some configuration
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;

    @GetMapping("/")
    @Scheduled(cron = "* */2 * * * *") //cron example evey 2 minute will do getMapping
    public GlobalHttpResponse<List<CategoryEntity>> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public GlobalHttpResponse<CategoryEntity> getById(@PathVariable("id") int id){
        return categoryService.getById(id);
    }
    @PostMapping("/")
    public GlobalHttpResponse<CategoryEntity> insertData(@RequestBody CategoryModel categoryModel){
        return categoryService.insertData(categoryModel);
    }
    @PutMapping("/{id}")
    public GlobalHttpResponse<CategoryEntity> updateById(@PathVariable("id")int id,
                                                         @RequestBody CategoryModel categoryModel){
        return categoryService.updateById(id, categoryModel);
    }
    @DeleteMapping("/{id}")
    public GlobalHttpResponse<CategoryEntity> deleteById(@PathVariable("id") int id){
        return categoryService.deleteById(id);
    }
}
