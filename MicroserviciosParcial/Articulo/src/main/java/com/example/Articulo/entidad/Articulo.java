package com.example.Articulo.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Articulo")
public class Articulo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int idArticulo;

    @NotNull(message ="El nombre no puede ser nulo")
    private String nombre;

    @NotNull(message ="El precio no puede ser nulo")
    private Float precio;


}
