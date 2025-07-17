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
            return detalleFacturaRepository.findByIdFactura(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving details for factura ID: " + id, e);
        }
    }

    @Override
    public DetalleFactura saveDetalle(DetalleFactura detalleFactura) {
        try {
            return detalleFacturaRepository.save(detalleFactura);
        } catch (Exception e) {
            throw new RuntimeException("Error saving detalle factura", e);
        }
    }

    @Override
    public DetalleFactura updateDetalle(DetalleFactura detalleFactura) {
        try {
            return detalleFacturaRepository.save(detalleFactura);
        } catch (Exception e) {
            throw new RuntimeException("Error updating detalle factura", e);
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            detalleFacturaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting detalle factura with ID: " + id, e);
        }
    }

}
