package com.example.Seguridad.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Seguridad.document.Seguridad;

@Repository
public interface Seguridadrepository extends MongoRepository<Seguridad, String> {

    Optional<Seguridad> findByNombre(String nombre);


}
