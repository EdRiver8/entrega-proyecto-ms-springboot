package com.poli.mus.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "aplicaciones")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Aplicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aplicacion_id")
    private Integer id;
    
    @Column(name = "fecha_aplicacion", nullable = false)
    private LocalDate fecha;

    @Column(name = "comentario", length = 200)
    private String comentarios;
    
    @ManyToOne
    @JoinColumn(name = "medicamento_id", nullable = false)
    private Medicamento medicamento;
    
    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;
    
    @ManyToOne
    @JoinColumn(name = "mascota_id", nullable = false)
    private Mascota mascota;
}