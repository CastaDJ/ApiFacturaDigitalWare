package com.dw.factura.services;

import java.util.List;

import com.dw.factura.entity.Factura;

public interface FacturaService {

    List<Factura> getAllFacturas();
    Factura getFacturaById(Integer id);
    Factura createFactura(Factura factura);
    Factura updateFactura(Integer id, Factura factura);
    void deleteFactura(Integer id);
    
}
