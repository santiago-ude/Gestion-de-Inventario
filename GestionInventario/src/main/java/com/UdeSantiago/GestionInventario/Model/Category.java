package com.UdeSantiago.GestionInventario.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity
@Table(name = "tbl_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    @NotBlank
    private String name;

    @Column(name = "category_description")
    @NotBlank
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JsonIgnore
    private List<Product> products;

    public Category() {
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
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
