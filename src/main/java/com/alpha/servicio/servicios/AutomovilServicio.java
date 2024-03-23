package com.alpha.servicio.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.servicio.modelos.AutomovilModelo;
import com.alpha.servicio.repositorios.IAutomovilRepository;

@Service
public class AutomovilServicio {
    @Autowired
    IAutomovilRepository automovilRepository;

    public ArrayList<Long> buscarChips(Long idClub){
        ArrayList<AutomovilModelo> automovilesActivos = automovilRepository.findByIdCliente_Club_IdClubAndIdCliente_ActivoAndActivo(idClub, 1, 1);
        ArrayList<Long> chipsFinales = new ArrayList<Long>();
        for (AutomovilModelo automovilModelo : automovilesActivos) {
            chipsFinales.add(automovilModelo.getIdChip());
        }
        return chipsFinales;
    }
}
