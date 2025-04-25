package com.UdeSantiago.GestionInventario.Controller;

import com.UdeSantiago.GestionInventario.Model.Category;
import com.UdeSantiago.GestionInventario.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService CS;


    @GetMapping
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(CS.getCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(CS.getCategoryById(id));
    }


    @PostMapping
    public ResponseEntity<?> postCategory(@Valid @RequestBody Category newCategory){
