package com.poli.mus.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clientes")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(length = 15)
    private String telefono;
    
    @Column(length = 100)
    private String email;
    
    @Column(length = 200)
    private String direccion;
    
//    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JsonManagedReference
    @Transient
    private List<Mascota> mascotas;
}
