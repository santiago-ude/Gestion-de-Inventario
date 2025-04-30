package com.UdeSantiago.GestionInventario.Repository;

import com.UdeSantiago.GestionInventario.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long idCategory);
    List<Product> findBySupplierId(Long idSupplier);
}
