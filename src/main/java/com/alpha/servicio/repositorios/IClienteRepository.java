package com.alpha.servicio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.servicio.modelos.ClienteModelo;

@Repository
public interface IClienteRepository extends JpaRepository<ClienteModelo, Long> {

}
