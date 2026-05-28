package com.rikkei.bai3.service;

import com.rikkei.bai3.dto.response.ProductDto;
import com.rikkei.bai3.dto.request.ProductCreateDto;

import java.util.List;

public interface ProductService {

    List<ProductDto> findAll();

    ProductDto findById(long id);
    ProductDto addProduct(ProductCreateDto productCreateDto);
}
