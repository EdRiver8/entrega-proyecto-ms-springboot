package com.dom.pelu.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "ventas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venta", nullable = false)
    private Integer codigoVenta;

    @Column(name = "fecha_venta", nullable = false)
    private LocalDate fechaVenta;

    @Column(name = "total_venta", nullable = false)
    private double totalVenta;

    @ManyToOne
    @JoinColumn(name = "documento_empleado", nullable = false)
    private Empleado empleado;

    @OneToMany(mappedBy = "venta")
    private List<DetalleVenta> detalles;
}

