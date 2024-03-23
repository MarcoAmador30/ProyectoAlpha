package com.alpha.servicio.repositorios;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.servicio.modelos.AutomovilModelo;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface IAutomovilRepository extends JpaRepository<AutomovilModelo, Long> {
    public Stream<AutomovilModelo> findByIdCliente_Club_IdClubAndIdCliente_ActivoAndActivo(Long idClub, int clienteActivo, int automovilActivo);
}
