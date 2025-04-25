package com.UdeSantiago.GestionInventario.Service;

import com.UdeSantiago.GestionInventario.Exception.ResourceNotFoundException;
import com.UdeSantiago.GestionInventario.Model.Category;
import com.UdeSantiago.GestionInventario.Model.Product;
import com.UdeSantiago.GestionInventario.Model.Supplier;
import com.UdeSantiago.GestionInventario.Repository.CategoryRepository;
import com.UdeSantiago.GestionInventario.Repository.SupplierRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class SupplierService {


    @Autowired
    SupplierRepository SP;

    //GET
    public List<Supplier> getSuppliers(){
        return SP.findAll();
    }

    //GETById
    public Supplier getSupplierById(Long id){
        return SP.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor con ID \" + id + \" no encontrado"));
    }

    //POST
    public Supplier postSupplier(Supplier newSupplier){
        return SP.save(newSupplier);
    }

    //PUT
    public Supplier putSupplier(Long id, Supplier newSupplier){

        return SP.findById(id)
                .map(aux -> {
                    BeanUtils.copyProperties(newSupplier, aux, "id");
                    return SP.save(aux);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor con ID " + id + " no encontrado"));


    }

    //PATCH
    public Supplier patchSupplier(Long id, Map<String, Object> update){
        return SP.findById(id)
                .map(existingProduct -> {
                    update.forEach((key,value) -> {
                        Field field = ReflectionUtils.findField(Category.class, key);
                        if(field != null){
                            field.setAccessible(true);
                            ReflectionUtils.setField(field, existingProduct,value);
                        }
                    });
                    return SP.save(existingProduct);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Proveedor con ID " + id + " no encontrado"));
    }

    //DELETE

    public void deleteSupplier(Long id){
        if(!SP.existsById(id)){
            throw new ResourceNotFoundException("Proveedor con ID " + id + " no encontrado");
        }
        SP.deleteById(id);
    }


}
