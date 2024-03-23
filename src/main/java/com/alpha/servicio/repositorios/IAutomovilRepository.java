package com.alpha.servicio.repositorios;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.servicio.modelos.AutomovilModelo;

@Repository
public interface IAutomovilRepository extends JpaRepository<AutomovilModelo, Long> {
    public ArrayList<AutomovilModelo> findByIdCliente_Club_IdClubAndIdCliente_ActivoAndActivo(Long idClub, int clienteActivo, int automovilActivo);
}
