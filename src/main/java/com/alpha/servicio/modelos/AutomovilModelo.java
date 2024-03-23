package com.alpha.servicio.modelos;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "automovil")
public class AutomovilModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutomovil;
    
    @Column(name = "color")
    private String color;

    @Column(name = "placas")
    private String placas;

    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private ClienteModelo idCliente;

    @Column(name = "id_chip")
    private Long idChip;

    @Column(name = "marca")
    private String marca;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name = "activo")
    private int activo;

    public String getColor() {
        return color;
    }

    public String getPlacas() {
        return placas;
    }

    public ClienteModelo getIdCliente() {
        return idCliente;
    }

    public Long getIdChip() {
        return idChip;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public Date getFechaActualizacion() {
        return fechaActualizacion;
    }

    public int getActivo() {
        return activo;
    }
}
