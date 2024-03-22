package com.prosigmaka.springbootpos.controller;

import com.prosigmaka.springbootpos.entity.CategoryEntity;
import com.prosigmaka.springbootpos.helper.GlobalHttpResponse;
import com.prosigmaka.springbootpos.model.CategoryModel;
import com.prosigmaka.springbootpos.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public GlobalHttpResponse<List<CategoryEntity>> getAll(){
        return categoryService.getAll();
    }
    @GetMapping("/{kata}")
    public GlobalHttpResponse<Optional<CategoryEntity>> getById(@PathVariable("kata") int id){
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
    public GlobalHttpResponse<CategoryEntity> deleteById(@PathVariable("id") int id,
                                                         @RequestBody CategoryModel categoryModel){
        return categoryService.deleteById(id, categoryModel);
    }
}
