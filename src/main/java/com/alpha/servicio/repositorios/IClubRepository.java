package com.alpha.servicio.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.servicio.modelos.ClubModelo;

@Repository
public interface IClubRepository extends JpaRepository<ClubModelo, Long>{

}
