package com.example.Movimiento.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Movimiento.entidad.Movimiento;



@Repository
public interface Movimientorepositorio extends JpaRepository<Movimiento,Serializable> {

}
