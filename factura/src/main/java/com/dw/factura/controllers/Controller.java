package com.dw.factura.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dw.factura.entity.Factura;
import com.dw.factura.services.FacturaService;

@RestController
@RequestMapping("/api/factura")
public class Controller {

    @Autowired
    private FacturaService facturaService;

    @GetMapping("/all")
    public ResponseEntity<List<Factura>> getFactura() {
        try {
            List<Factura> factura = facturaService.getAllFacturas();
            if (factura == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(factura);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable Integer id) {
        try {
            Factura factura = facturaService.getFacturaById(id);
            if (factura == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(factura);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
        try {
            if (factura.getFechaEmision() == null) {
                factura.setFechaEmision(new Date());
            }
            factura.setFechaEmision(new Date());
            Factura createdFactura = facturaService.createFactura(factura);
            return ResponseEntity.status(201).body(createdFactura);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Factura> updateFactura(@RequestBody Factura factura,@PathVariable Integer id) {
        try {
            Factura updatedFactura = facturaService.updateFactura(id, factura);
            if (updatedFactura == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedFactura);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable Integer id) {
        try {
            facturaService.deleteFactura(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
