package com.poli.mus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "historial_estados")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class HistorialEstado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historial_estado_id")
    private Integer id;
    
    @Column(name = "fecha_cambio", nullable = false)
    private LocalDate fechaCambio;

    @Column(name = "comentario", length = 200)
    private String comentarios;
    
    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;
    
    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;
    
    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;
}