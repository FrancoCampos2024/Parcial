package com.example.Articulo.servicios;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Articulo.entidad.Articulo;
import com.example.Articulo.repository.Articulorepository;

@Service
public class Articuloservicio {

    private static final Logger logger = LoggerFactory.getLogger(Articuloservicio.class);

    @Autowired
    private Articulorepository Articulorepo;


    public Articulo crear(Articulo c){
        logger.info("Creando un nuevo articulos con nombre: {}, precio: {}", c.getNombre(),c.getPrecio());
        Articulo nuevo= Articulorepo.save(c);
        Articulorepo.save(c);
        logger.info("Articulo creado con ID: {}", nuevo.getIdArticulo());
        return nuevo;
    }

    public List<Articulo> listar(){
        logger.info("Obteniendo todos los articulos");
        List<Articulo> Articulos= Articulorepo.findAll();
        if (Articulos.isEmpty()) {
        logger.warn("No se encontraron articulos en la base de datos");
        throw new RuntimeException("No se encontraron articulos registrados");
    }
        logger.info("Se encontraron {} clientes", Articulos.size());
        return Articulos;
    }
    
}
