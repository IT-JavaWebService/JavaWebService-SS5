package com.rikkei.bai3.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class ProductCreateDto {
    private String name;
    private Double price;
}