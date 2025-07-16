package com.dw.factura.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @Column(name = "id_factura")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Column(name = "total")
    private Double total;

    @Column(name = "id_cliente")
    private Integer idCliente;
}
