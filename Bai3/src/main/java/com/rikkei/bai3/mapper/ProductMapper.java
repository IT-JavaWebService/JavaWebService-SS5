package com.rikkei.bai3.mapper;

import com.rikkei.bai3.dto.response.ProductDto;
import com.rikkei.bai3.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static List<ProductDto> mapper(List<Product> product){
        List<ProductDto> productDto = new ArrayList<>();
        for(Product p : product) {
            productDto.add(new ProductDto(p.getId(), p.getName(), p.getPrice()));
        }
        return productDto;
    }

    public static ProductDto mapper(Product product) {
        return new ProductDto(product.getId(), product.getName(), product.getPrice());
    }

}
