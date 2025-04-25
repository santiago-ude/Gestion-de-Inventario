package com.UdeSantiago.GestionInventario.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Table(name = "tbl_supplier")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Column(name = "supplier_name")
    private String name;

    @NotBlank(message = "El numero no puede estar vacio")
    @Column(name = "supplier_number")
    private String number;

    @NotBlank(message = "El email no puede estar vacio")
    @Column(name = "supplier_email")
    @Email(message = "Debe ingresar un email valido")
    private String email;

    @NotBlank(message = "La direccion no puede estar vacio")
    @Column(name = "supplier_address")
    private String address;

    @OneToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<Product> products;

    public Supplier() {
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
