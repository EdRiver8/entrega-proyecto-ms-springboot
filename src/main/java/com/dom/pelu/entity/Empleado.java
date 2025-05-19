package com.dom.pelu.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado {
    @Id
    @Column(name = "documento_empleado", nullable = false)
    private Integer documento;

    @Column(name = "nombre_empleado", nullable = false)
    private String nombre;

    @Column(name = "apellido1_empleado", nullable = false)
    private String apellido1;

    @Column(name = "apellido2_empleado")
    private String apellido2;
    @JsonIgnore
    @OneToMany(mappedBy = "empleado")
    private List<Venta> ventas;
}
