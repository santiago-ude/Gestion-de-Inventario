package com.UdeSantiago.GestionInventario.Service;


import com.UdeSantiago.GestionInventario.Model.Category;
import com.UdeSantiago.GestionInventario.Model.ProductRequestDTO;
import com.UdeSantiago.GestionInventario.Model.Supplier;
import com.UdeSantiago.GestionInventario.Repository.CategoryRepository;
import com.UdeSantiago.GestionInventario.Repository.SupplierRepository;
import org.springframework.util.ReflectionUtils;
import com.UdeSantiago.GestionInventario.Exception.ResourceNotFoundException;
import com.UdeSantiago.GestionInventario.Model.Product;
import com.UdeSantiago.GestionInventario.Repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository PR;

    @Autowired
    CategoryRepository CR;

    @Autowired
    SupplierRepository SR;

    public List<Product> getProducts(){
        return PR.findAll();
    }


    public Product getProductById(Long id){
        return PR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado"));
    }

    public Product postProduct(ProductRequestDTO dto){

        // Validar categoría
        Long categoryId = dto.getCategoryId();
        Category category = CR.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría con ID " + categoryId + " no encontrada"));

        // Validar proveedor
        Long supplierId = dto.getSupplierId();
        Supplier supplier = SR.findById(supplierId)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor con ID " + supplierId + " no encontrado"));

        // Asignar entidades verificadas

        Product newProduct = new Product();

        newProduct.setCategory(category);
        newProduct.setSupplier(supplier);
        newProduct.setImageUrl(dto.getImageUrl());
        newProduct.setStock(dto.getStock());
        newProduct.setPrice(dto.getPrice());
        newProduct.setName(dto.getName());
        newProduct.setDescription(dto.getDescription());
        newProduct.setBrand(dto.getBrand());

        return PR.save(newProduct);
    }

    public Product putProduct(Long id, Product newProduct){

        return PR.findById(id)
                .map(aux -> {
                    BeanUtils.copyProperties(newProduct, aux, "id");
                    return PR.save(aux);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado"));
    }


    public Product patchProduct(Long id, Map<String, Object> updates) {
        return PR.findById(id)
                .map(existingProduct -> {
                    updates.forEach((key, value) -> {
                        Field field = ReflectionUtils.findField(Product.class, key);
                        if (field != null) {
                            field.setAccessible(true);
                            ReflectionUtils.setField(field, existingProduct, value);
                        }
                    });
                    return PR.save(existingProduct);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado"));
    }

    public void deleteProduct(Long id){

        if(!PR.existsById(id)){
            throw new ResourceNotFoundException("Producto con ID " + id + " no encontrado");
        }
        PR.deleteById(id);
    }



}
