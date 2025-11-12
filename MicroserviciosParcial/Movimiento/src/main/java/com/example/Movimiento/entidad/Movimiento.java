package com.example.Movimiento.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movimiento")
public class Movimiento  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMovimiento;

    @NotNull(message = "El ID del artículo no puede ser nulo")
    @Column(nullable = false)
    private Integer idArticulo;

    @NotBlank(message = "El tipo de movimiento no puede estar vacío")
    @Column(nullable = false)
    private String tipoMovimiento;

    @NotNull(message = "La cantidad no puede ser nula")
    @Min(value = 1, message = "La cantidad debe ser mayor que cero")
    @Column(nullable = false)
    private Integer cantidad;

    @NotNull(message = "El estado no puede ser nulo")
    @Column(nullable = false)
    private Boolean estado;
    

}
