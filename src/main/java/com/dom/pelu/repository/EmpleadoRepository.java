package com.dom.pelu.repository;

import com.dom.pelu.dto.reporteDTO.EmpleadoVentaDTO;
import com.dom.pelu.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query("""
        SELECT new com.dom.pelu.dto.reporteDTO.EmpleadoVentaDTO(e.documento, CONCAT(e.nombre, ' ', e.apellido1, ' ', COALESCE(e.apellido2, '')))
        FROM Empleado e 
        WHERE SIZE(e.ventas) > 0
        """)
    List<EmpleadoVentaDTO> empleadosConVentas();
}
