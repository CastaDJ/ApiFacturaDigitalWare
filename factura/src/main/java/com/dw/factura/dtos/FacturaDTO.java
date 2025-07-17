package com.dw.factura.dtos;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class FacturaDTO {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("fecha_emision")
    private Date fechaEmision;
    @JsonProperty("total")
    private double total;
    @JsonProperty("id_cliente")
    private Integer idCliente;
    @JsonProperty("cantidad_detalle")
    private int cantidadDetalle;
    @JsonProperty("subtotal_detalle")
    private double subtotalDetalle;
}
