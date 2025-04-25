package com.UdeSantiago.GestionInventario.Service;

import com.UdeSantiago.GestionInventario.Exception.ResourceNotFoundException;
import com.UdeSantiago.GestionInventario.Model.Category;
import com.UdeSantiago.GestionInventario.Model.Product;
import com.UdeSantiago.GestionInventario.Repository.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.sql.Ref;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {


    @Autowired
    CategoryRepository CR;

    //GET
    public List<Category> getCategories(){
        return CR.findAll();
    }

    //GETById

    public Category getCategoryById(Long id){
        return CR.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria con ID \" + id + \" no encontrada"));
    }

    //POST
    public Category postCategory(Category newCategory){
        return CR.save(newCategory);
    }

    //PUT
    public Category putCategory(Long id, Category newCategory){

        return CR.findById(id)
                .map(aux -> {
                    BeanUtils.copyProperties(newCategory, aux, "id");
                    return CR.save(aux);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Categoria con ID " + id + " no encontrada"));


    }

    //PATCH
    public Category patchCategory(Long id, Map<String, Object> update){
        return CR.findById(id)
                .map(existingProduct -> {
                    update.forEach((key,value) -> {
                        Field field = ReflectionUtils.findField(Category.class, key);
                        if(field != null){
                            field.setAccessible(true);
                            ReflectionUtils.setField(field, existingProduct,value);
                        }
                    });
                    return CR.save(existingProduct);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Categoria con ID " + id + " no encontrada"));
    }

    //DELETE

    public void deleteCategory(Long id){
        if(!CR.existsById(id)){
            throw new ResourceNotFoundException("Categoria con ID " + id + " no encontrada");
        }
        CR.deleteById(id);
    }


}
