package com.example.Seguridad.servicios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Seguridad.document.Seguridad;
import com.example.Seguridad.repository.Seguridadrepository;

@Service
public class Seguridadservicios {

    private static final Logger logger = LoggerFactory.getLogger(Seguridadservicios.class);

    @Autowired
    private Seguridadrepository seguridadrepository;

    public boolean verificarCredenciales(String nombre, String clave) {
    logger.info("Verificando credenciales para el usuario: {}", nombre);

    return seguridadrepository.findByNombre(nombre)
            .map(usuario -> {
                if (usuario.getClave().equals(clave)) {
                    logger.info("Usuario y clave correctos: {}", nombre);
                    return true;
                } else {
                    logger.warn("Clave incorrecta para el usuario: {}", nombre);
                    return false;
                }
            })
            .orElseGet(() -> {
                logger.warn("Usuario no encontrado: {}", nombre);
                return false;
            });
        }


        public Seguridad guardarUsuario(Seguridad usuario) {
            logger.info("Guardando nuevo usuario: {}", usuario.getNombre());
            return seguridadrepository.save(usuario);
        }


}
