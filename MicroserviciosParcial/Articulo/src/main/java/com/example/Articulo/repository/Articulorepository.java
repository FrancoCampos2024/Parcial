package com.example.Articulo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Articulo.entidad.Articulo;

@Repository
public interface Articulorepository extends JpaRepository<Articulo, Serializable> {

}
