package com.example.Articulo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Articulo.config.ArticuloRutas;
import com.example.Articulo.entidad.Articulo;
import com.example.Articulo.servicios.Articuloservicio;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;






@RestController
@RequestMapping(ArticuloRutas.BASE)
public class Articulocontroller {

    @Autowired
    private Articuloservicio articuloservicio;

    @GetMapping(ArticuloRutas.LISTAR)
    public List<Articulo> lista() {
        return articuloservicio.listar();
    }
    

    @PostMapping(ArticuloRutas.CREAR)
    public Articulo crearp(@Valid @RequestBody Articulo c) {
        Articulo ci= new Articulo(c.getIdArticulo(), c.getNombre(), c.getPrecio());
        return articuloservicio.crear(ci);
    }
   
}
