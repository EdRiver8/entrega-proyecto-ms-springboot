package com.poli.vet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "estados")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estado_id")
    private Integer id;
    
    @Column(nullable = false, length = 50)
    private String nombre;
    
    @OneToMany(mappedBy = "estado")
    private List<HistorialEstado> historialEstados;
}
