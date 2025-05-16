package com.poli.mus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "mascotas")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mascota_id")
    private Integer id;
    
    @Column(nullable = false, length = 50)
    private String nombre;
    
    @Column(nullable = false, length = 30)
    private String especie;
    
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(nullable = false, name = "cliente_id", insertable = false, updatable = false)
    private Integer clienteId;
    
//    @ManyToOne
//    @JsonBackReference
//    @JsonIgnore
//    @JoinColumn(name = "cliente_id", nullable = false)
//    private Cliente cliente;
    
//    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
//    private List<Aplicacion> aplicaciones;
//
//    @OneToMany(mappedBy = "mascota", cascade = CascadeType.ALL)
//    private List<HistorialEstado> historialEstados;
}