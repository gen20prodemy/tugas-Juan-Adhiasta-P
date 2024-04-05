package com.prosigmaka.SpringSecurity.controller;

import com.prosigmaka.SpringSecurity.helper.GlobalHttpResponse;
import com.prosigmaka.SpringSecurity.model.ProductModel;
import com.prosigmaka.SpringSecurity.model.ProductResponseModel;
import com.prosigmaka.SpringSecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<GlobalHttpResponse<List<ProductResponseModel>>> getAll(){
        GlobalHttpResponse<List<ProductResponseModel>> response = productService.getAll();
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalHttpResponse<ProductResponseModel>> getById(@PathVariable("id") int id){
        GlobalHttpResponse<ProductResponseModel> response = productService.getById(id);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
    }

    @PostMapping("/")
    public ResponseEntity<GlobalHttpResponse<ProductResponseModel>> insert(@RequestBody ProductModel productModel){
        GlobalHttpResponse<ProductResponseModel> product = productService.insert(productModel);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(product.getStatus()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalHttpResponse<ProductResponseModel>> updateById(@PathVariable("id") int id,
                                                                               @RequestBody ProductModel productModel){
        GlobalHttpResponse<ProductResponseModel> result = productService.updateById(id, productModel);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatus()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalHttpResponse<ProductResponseModel>> deleteById(@PathVariable("id") int id){
        GlobalHttpResponse<ProductResponseModel> result = productService.deleteById(id);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatus()));
    }
}
