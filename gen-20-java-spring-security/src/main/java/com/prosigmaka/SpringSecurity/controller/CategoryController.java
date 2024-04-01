package com.prosigmaka.SpringSecurity.controller;

import com.prosigmaka.SpringSecurity.entity.CategoryEntity;
import com.prosigmaka.SpringSecurity.helper.GlobalHttpResponse;
import com.prosigmaka.SpringSecurity.model.CategoryModel;
import com.prosigmaka.SpringSecurity.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
@AllArgsConstructor
public class CategoryController {
    @Autowired
    private final CategoryService categoryService;

    @GetMapping("/")
    public GlobalHttpResponse<List<CategoryEntity>> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public GlobalHttpResponse<Optional<CategoryEntity>> getById(@PathVariable("id") int id){
        return categoryService.getById(id);
    }

    @PostMapping("/")
    public GlobalHttpResponse<CategoryEntity> insertData(@RequestBody CategoryModel categoryModel){
        return categoryService.insertData(categoryModel);
    }

    @PutMapping("/{id}")
    public GlobalHttpResponse<CategoryEntity> updateById(@PathVariable("id") int id,
                                                         @RequestBody CategoryModel categoryModel){
        return categoryService.updateById(id, categoryModel);
    }

    @DeleteMapping("/{id}")
    public GlobalHttpResponse<CategoryEntity> deleteById(@PathVariable("id") int id,
                                                         @RequestBody CategoryModel categoryModel){
        return categoryService.deleteById(id, categoryModel);
    }
}
