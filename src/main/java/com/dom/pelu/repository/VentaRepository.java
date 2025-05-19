package com.dom.pelu.repository;

import com.dom.pelu.dto.reporteDTO.ReporteVentasPorDiaDTO;
import com.dom.pelu.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {
    @Query("""
        SELECT new com.dom.pelu.dto.reporteDTO.ReporteVentasPorDiaDTO(v.fechaVenta, SUM(v.totalVenta))
        FROM Venta v 
        GROUP BY v.fechaVenta
        ORDER BY v.fechaVenta
        """)
    List<ReporteVentasPorDiaDTO> totalVentasPorDia();

}
