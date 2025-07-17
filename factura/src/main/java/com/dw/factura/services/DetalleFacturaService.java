package com.dw.factura.services;

import java.util.List;

import com.dw.factura.entity.DetalleFactura;

public interface DetalleFacturaService {

    List<DetalleFactura> getAllById(Integer id);
    DetalleFactura saveDetalle(DetalleFactura detalleFactura);
    DetalleFactura updateDetalle(DetalleFactura detalleFactura);
    void delete(Integer id);
}
