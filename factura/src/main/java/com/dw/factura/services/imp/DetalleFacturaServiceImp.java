package com.dw.factura.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dw.factura.entity.DetalleFactura;
import com.dw.factura.repositories.DetalleFacturaRepository;
import com.dw.factura.services.DetalleFacturaService;

@Service
public class DetalleFacturaServiceImp implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaRepository detalleFacturaRepository;

    @Override
    public List<DetalleFactura> getAllById(Integer id) {
        try {
            return detalleFacturaRepository.findByFacturaId(id);
        } catch (Exception e) {
            // Handle exception (e.g., log it)
            throw new RuntimeException("Error retrieving details for factura ID: " + id, e);
        }
    }

}
