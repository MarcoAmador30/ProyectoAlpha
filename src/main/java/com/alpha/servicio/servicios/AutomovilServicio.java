package com.alpha.servicio.servicios;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.servicio.modelos.AutomovilModelo;
import com.alpha.servicio.repositorios.IAutomovilRepository;

import jakarta.transaction.Transactional;

@Service
public class AutomovilServicio {
    @Autowired
    IAutomovilRepository automovilRepository;

    @Transactional
    public ArrayList<Long> buscarChips(Long idClub){
        Stream<AutomovilModelo> automovilesActivos = automovilRepository.findByIdCliente_Club_IdClubAndIdCliente_ActivoAndActivo(idClub, 1, 1);
        ArrayList<Long> chipsFinales = new ArrayList<Long>();
        automovilesActivos.forEach((automovil)->{
            chipsFinales.add(automovil.getIdChip());
        });
        return chipsFinales;
    }
}
