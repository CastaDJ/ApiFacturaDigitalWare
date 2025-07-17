package com.dw.factura.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.factura.entity.Factura;
import com.dw.factura.repositories.FacturaRepository;
import com.dw.factura.services.FacturaService;

@Service
public class FacturaServiceImp implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public List<Factura> getAllFacturas() {
        try {
            return facturaRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving all facturas", e);
        }
    }

    @Override
    public Factura getFacturaById(Integer id) {
        try {
            return facturaRepository.getReferenceById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving factura by ID: " + id, e);
        }
    }

    @Override
    public Factura createFactura(Factura factura) {
        try {
            return facturaRepository.save(factura);
        } catch (Exception e) {
            throw new RuntimeException("Error creating factura", e);
        }
    }

    @Override
    public Factura updateFactura(Integer id, Factura factura) {
        try {
            factura.setIdFactura(id);
            return facturaRepository.save(factura);
        } catch (Exception e) {
            throw new RuntimeException("Error updating factura with ID: " + id, e);
        }
    }

    @Override
    public void deleteFactura(Integer id) {
        try {
            facturaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting factura with ID: " + id, e);
        }
    }

}
