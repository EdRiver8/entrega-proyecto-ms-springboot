package com.dom.pelu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "productos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_producto", nullable = false)
    private Integer codigo;

    @Column(name = "nombre_producto", nullable = false)
    private String nombre;

    @Column(name = "precio_producto", nullable = false)
    private double precio;

    @Column(name = "stock_producto", nullable = false)
    private Integer stock;

    @Column(name = "fecha_vencimiento")
    private LocalDate fechaVencimiento;

    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private List<DetalleVenta> detalles;

    @ManyToMany
    @JoinTable(
            name = "productos_categorias",
            joinColumns = @JoinColumn(name = "codigo_producto"),
            inverseJoinColumns = @JoinColumn(name = "codigo_categoria")
    )
    private List<Categoria> categorias;
}

