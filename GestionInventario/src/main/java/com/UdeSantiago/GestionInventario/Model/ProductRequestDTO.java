package com.UdeSantiago.GestionInventario.Model;

import java.math.BigDecimal;

public class ProductRequestDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private String brand;
    private String imageUrl;
    private Long categoryId;
    private Long supplierId;

    public ProductRequestDTO() {
    }



    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

}
