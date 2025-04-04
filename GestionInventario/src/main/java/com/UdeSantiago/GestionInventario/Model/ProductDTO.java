package com.UdeSantiago.GestionInventario.Model;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ProductDTO {

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String name;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", inclusive = false, message = "El precio debe ser mayor a 0")
    private BigDecimal price;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @NotBlank(message = "La marca es obligatoria")
    private String brand;

    @NotBlank(message = "La URL de la imagen es obligatoria")
    @Pattern(regexp = "^(http|https)://.*$", message = "La URL de la imagen debe ser válida")
    private String imageUrl;

    public ProductDTO() {
    }

    public ProductDTO(String name, String description, BigDecimal price, Integer stock, String brand, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.imageUrl = imageUrl;
    }
}