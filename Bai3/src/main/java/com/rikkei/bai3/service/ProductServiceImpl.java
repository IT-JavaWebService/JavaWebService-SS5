package com.rikkei.bai3.service;

import com.rikkei.bai3.dto.response.ProductDto;
import com.rikkei.bai3.dto.request.ProductCreateDto;
import com.rikkei.bai3.entity.Product;
import com.rikkei.bai3.mapper.ProductMapper;
import com.rikkei.bai3.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    @Override
    public List<ProductDto> findAll() {
        return ProductMapper.mapper(productRepository.findAll());

    }

    @Override
    public ProductDto findById(long id) {
        return ProductMapper.mapper(productRepository.findById(id).get());
    }

    @Override
    public ProductDto addProduct(ProductCreateDto productCreateDto) {
        Product product = new Product();
        product.setName(productCreateDto.getName());
        product.setPrice(productCreateDto.getPrice());
        productRepository.save(product);

        return ProductMapper.mapper(product);
    }
}
