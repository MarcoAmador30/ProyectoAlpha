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
@Table(name = "cliente")
public class ClienteModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;

    @Column(name = "activo")
    private int activo;

    @Column(name = "acceso_permitido")
    private int accesoPermitido;

    @ManyToOne()
    @JoinColumn(name = "id_club")
    private ClubModelo club;

    public Long getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
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

    public int getAccesoPermitido() {
        return accesoPermitido;
    }

    public ClubModelo getClub() {
        return club;
    }
}
