package com.example.Movimiento.servicio;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Movimiento.entidad.Movimiento;
import com.example.Movimiento.repository.Movimientorepositorio;

@Service
public class Movimientoservicios {

    @Autowired
    private Movimientorepositorio movimientorepositorio;

    private static final Logger logger = LoggerFactory.getLogger(Movimientoservicios.class);

    public Movimiento crear(Movimiento m) {
        logger.info("Creando movimiento → ID Artículo: {}, Tipo: {}, Cantidad: {}, Estado: {}", 
                    m.getIdArticulo(), m.getTipoMovimiento(), m.getCantidad(), m.getEstado());
        Movimiento movimientoGuardado = movimientorepositorio.save(m);
        logger.info("Movimiento creado exitosamente con ID: {}", movimientoGuardado.getIdMovimiento());
        return movimientoGuardado;
    }

    public Movimiento buscarPorId(int id) {
        logger.info("Buscando movimiento con ID: {}", id);
        Optional<Movimiento> movimiento = movimientorepositorio.findById(id);

        if (movimiento.isPresent()) {
            logger.info("Movimiento encontrado: {}", id);
            return movimiento.get();
        } else {
            logger.warn("Movimiento no encontrado con ID: {}", id);
            return null;
        }
    }

    public Movimiento guardarCambio(Movimiento movimiento) {
        logger.info("Guardando cambios del movimiento con ID: {}", movimiento.getIdMovimiento());
        return movimientorepositorio.save(movimiento);
    }
}
