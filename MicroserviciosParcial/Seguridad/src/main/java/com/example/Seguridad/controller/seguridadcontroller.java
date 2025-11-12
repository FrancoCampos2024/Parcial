package com.example.Seguridad.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Seguridad.config.SeguridadRoutes;
import com.example.Seguridad.document.Seguridad;
import com.example.Seguridad.servicios.Seguridadservicios;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;






@RestController
@RequestMapping(SeguridadRoutes.BASE)
public class seguridadcontroller {
    @Autowired
    private Seguridadservicios seguridadServicio;

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestParam String nombre, @RequestParam String clave) {
        boolean valido = seguridadServicio.verificarCredenciales(nombre, clave);

        if (valido) {
            return ResponseEntity.ok("Usuario y clave correctos");
        } else {
            return ResponseEntity.status(401).body("Usuario o clave incorrectos");
        }
    }

    @PostMapping("/crear")
    public Seguridad crearp(@Valid @RequestBody Seguridad entity) {
        Seguridad nuevoUsuario = seguridadServicio.guardarUsuario(entity);
        return nuevoUsuario;
    }
    
}
