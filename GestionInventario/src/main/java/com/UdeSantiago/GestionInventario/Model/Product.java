package com.UdeSantiago.GestionInventario.Model;


import com.UdeSantiago.GestionInventario.Enum.Categoria;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_product")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    @Column(name = "name_product")
    private String name;


    @Size(max = 200, message = "La descripcion no puede exeder los 500 caracteres")
    @Column(name = "description_product")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @Column(name = "price_product")
    private BigDecimal price;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(name = "stock_product")
    private Integer stock;

    @NotBlank(message = "La marca es obligatoria")
    @Column(name = "marca_product")
    private String marca;

    @Pattern(regexp = "^(http|https)://.*$", message = "La URL de la imagen debe ser válida")
    @Column(name = "imageUrl_product")
    private String imageUrl;
    

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, Integer stock, String brand, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
}
