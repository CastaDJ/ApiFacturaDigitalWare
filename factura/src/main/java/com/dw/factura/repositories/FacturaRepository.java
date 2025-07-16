package com.dw.factura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dw.factura.entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {

}
