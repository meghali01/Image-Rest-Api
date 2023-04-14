package com.imagerestapi.payload;

import lombok.Data;

@Data
public class ItemDto {
    private Long id;

    private String name;
    private String category;
    private Integer quantity;
    private Double price;
}
