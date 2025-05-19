package com.dom.pelu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_categoria", nullable = false)
    private Integer codigo;

    @Column(name = "nombre_categoria", nullable = false)
    private String nombre;

    @JsonBackReference
    @ManyToMany(mappedBy = "categorias")
    private List<Producto> productos;
}

