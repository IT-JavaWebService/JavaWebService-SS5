package com.rikkei.bai3.controller;

import com.rikkei.bai3.dto.response.ProductDto;

import lombok.RequiredArgsConstructor;
import com.rikkei.bai3.dto.request.ProductCreateDto;
import com.rikkei.bai3.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    //    GetAll (Lay tat ca san pham)
    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }
    //    GetById (Lay san pham theo id)
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }
    //    Post (Them san pham)
    @PostMapping("/products")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductCreateDto productCreateDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(productCreateDto));
    }
}


