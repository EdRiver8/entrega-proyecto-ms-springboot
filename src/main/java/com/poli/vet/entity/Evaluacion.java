package com.poli.vet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "evaluaciones")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evaluacion_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "alumno_id", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor profesor;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Double calificacion;

    @Column(length = 500)
    private String observaciones;
}
