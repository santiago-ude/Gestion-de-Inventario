package com.UdeSantiago.GestionInventario.Service;

import com.UdeSantiago.GestionInventario.Model.ProductDTO;
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

    public List<Product> getProducts(){
        return PR.findAll();
    }


    public Product getProductById(Long id){
        return PR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto con ID " + id + " no encontrado"));
    }

    public Product postProduct(Product newProduct){

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
