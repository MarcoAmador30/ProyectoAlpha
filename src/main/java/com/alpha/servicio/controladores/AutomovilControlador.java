package com.alpha.servicio.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.servicio.servicios.AutomovilServicio;

@RestController
@RequestMapping("/automovil")
public class AutomovilControlador {
    @Autowired
    private AutomovilServicio automovilServicio;

    @GetMapping(path = "/{id}")
    public ArrayList<Long> getChipAutomovil(@PathVariable Long id){
        return this.automovilServicio.buscarChips(id);
    }
}
