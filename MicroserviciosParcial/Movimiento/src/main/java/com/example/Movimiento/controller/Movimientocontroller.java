package com.example.Movimiento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Movimiento.entidad.Movimiento;
import com.example.Movimiento.servicio.Movimientoservicios;
import com.example.Movimiento.config.MovimientoRutas;
import jakarta.validation.Valid;

@RestController
@RequestMapping(MovimientoRutas.BASE)
public class Movimientocontroller {
 
    @Autowired
    private Movimientoservicios movimientoServicio;

    @PostMapping(MovimientoRutas.CREAR)
    public Movimiento crearMovimiento(@Valid @RequestBody Movimiento m) {
        Movimiento nuevo = new Movimiento(
            m.getIdMovimiento(),
            m.getIdArticulo(),
            m.getTipoMovimiento(),
            m.getCantidad(),
            m.getEstado()
        );
        return movimientoServicio.crear(nuevo);
    }

    
    @PutMapping(MovimientoRutas.MODIFICAR)
    public String actualizarEstado(@PathVariable int id, @RequestParam boolean estado) {
        Movimiento movimiento = movimientoServicio.buscarPorId(id);

        if (movimiento == null) {
            return "Movimiento no encontrado con ID: " + id;
        }

        movimiento.setEstado(estado);
        movimientoServicio.guardarCambio(movimiento);

        return "Estado actualizado correctamente para el movimiento ID: " + id;
    }
}
