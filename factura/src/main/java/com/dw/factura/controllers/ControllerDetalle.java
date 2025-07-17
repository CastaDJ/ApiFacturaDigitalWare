package com.dw.factura.controllers;

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

import com.dw.factura.entity.DetalleFactura;
import com.dw.factura.services.DetalleFacturaService;

@RestController
@RequestMapping("/api/factura/detalle")
public class ControllerDetalle {


    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @GetMapping("/all/{id}")
    public ResponseEntity<List<DetalleFactura>> getAllById(@PathVariable Integer id) {
        try {
            List<DetalleFactura> detalles = detalleFacturaService.getAllById(id);
            if (detalles.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(detalles);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<DetalleFactura> createDetalle(@RequestBody DetalleFactura detalleFactura) {
        try {
            DetalleFactura createdDetalle = detalleFacturaService.saveDetalle(detalleFactura);
            return ResponseEntity.status(201).body(createdDetalle);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<DetalleFactura> updateDetalle(@RequestBody DetalleFactura detalleFactura, @PathVariable Integer id) {
        try {
            detalleFactura.setIdDetalle(id);
            DetalleFactura updatedDetalle = detalleFacturaService.updateDetalle(detalleFactura);
            return ResponseEntity.ok(updatedDetalle);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalle(@PathVariable Integer id) {
        try {
            detalleFacturaService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
