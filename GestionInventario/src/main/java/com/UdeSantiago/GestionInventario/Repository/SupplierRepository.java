package com.UdeSantiago.GestionInventario.Repository;

import com.UdeSantiago.GestionInventario.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
