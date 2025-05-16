package com.poli.mus.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "medicamentos")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Medicamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicamento_id")
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(name = "cantidad_stock", nullable = false)
    private Integer cantidadStock;
    
    @Column(nullable = false)
    private Double precio;
    
    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;
    
    @OneToMany(mappedBy = "medicamento", cascade = CascadeType.ALL)
    private List<Aplicacion> aplicaciones;
}