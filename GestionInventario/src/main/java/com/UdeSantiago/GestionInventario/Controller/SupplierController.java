package com.UdeSantiago.GestionInventario.Controller;

import com.UdeSantiago.GestionInventario.Model.Product;
import com.UdeSantiago.GestionInventario.Model.Supplier;
import com.UdeSantiago.GestionInventario.Service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    SupplierService SS;

    @GetMapping
    public ResponseEntity<?> getSuppliers(){
        return ResponseEntity.ok(SS.getSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSupplierById(@PathVariable Long id){
        return ResponseEntity.ok(SS.getSupplierById(id));
    }

    @PostMapping
    public ResponseEntity<?> postSupplier(@RequestBody Supplier newSupplier){

        Supplier aux = SS.postSupplier(newSupplier);

        URI location = ServletUriComponentsBuilder
