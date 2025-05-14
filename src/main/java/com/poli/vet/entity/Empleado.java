package com.poli.vet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "empleados")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false, length = 50)
    private String rol;

    @Column(nullable = false, length = 50)
    private String horario;
    
    @OneToMany(mappedBy = "empleado")
    private List<Aplicacion> aplicaciones;
    
    @OneToMany(mappedBy = "empleado")
    private List<HistorialEstado> historialEstados;
}