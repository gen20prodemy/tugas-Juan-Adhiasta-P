package com.prosigmaka.springkafkademo.controller;

import com.prosigmaka.springkafkademo.dto.ProductDto;
import com.prosigmaka.springkafkademo.dto.ProductResponseDto;
import com.prosigmaka.springkafkademo.helper.GlobalHttpResponse;
import com.prosigmaka.springkafkademo.service.ProductService;
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
    public ResponseEntity<GlobalHttpResponse<List<ProductResponseDto>>> getAll(){
        GlobalHttpResponse<List<ProductResponseDto>> response = productService.getAll();
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GlobalHttpResponse<ProductResponseDto>> getById(@PathVariable("id") int id){
        GlobalHttpResponse<ProductResponseDto> response = productService.getById(id);
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getStatus()));
    }

    @PostMapping("/")
    public ResponseEntity<GlobalHttpResponse<ProductResponseDto>> insert(@RequestBody ProductDto productModel){
        GlobalHttpResponse<ProductResponseDto> product = productService.insert(productModel);
        return new ResponseEntity<>(product, HttpStatusCode.valueOf(product.getStatus()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GlobalHttpResponse<ProductResponseDto>> updateById(@PathVariable("id") int id,
                                                                             @RequestBody ProductDto productModel){
        GlobalHttpResponse<ProductResponseDto> result = productService.updateById(id, productModel);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatus()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GlobalHttpResponse<ProductResponseDto>> deleteById(@PathVariable("id") int id){
        GlobalHttpResponse<ProductResponseDto> result = productService.deleteById(id);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatus()));
    }
}
