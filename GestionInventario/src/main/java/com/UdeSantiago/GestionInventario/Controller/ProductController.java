package com.UdeSantiago.GestionInventario.Controller;

import com.UdeSantiago.GestionInventario.Model.Product;
import com.UdeSantiago.GestionInventario.Model.ProductRequestDTO;
import com.UdeSantiago.GestionInventario.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    ProductService PS;


    @GetMapping
    public ResponseEntity<?> getProducts(){
        return ResponseEntity.ok(PS.getProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProducts(@PathVariable Long id){
        return ResponseEntity.ok(PS.getProductById(id));
    }


    @PostMapping
    public ResponseEntity<?> postProduct(@Valid @RequestBody ProductRequestDTO newProduct){

        Product aux = PS.postProduct(newProduct);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(aux.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> putProduct(@PathVariable long id, @Valid @RequestBody Product newProduct){

        Product aux = PS.putProduct(id,newProduct);
        return ResponseEntity.ok(aux);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> patchProduct(@PathVariable long id, @Valid @RequestBody Map<String, Object> newProduct){

        Product aux = PS.patchProduct(id, newProduct);
        return ResponseEntity.ok(aux);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable long id){

        PS.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }


}
