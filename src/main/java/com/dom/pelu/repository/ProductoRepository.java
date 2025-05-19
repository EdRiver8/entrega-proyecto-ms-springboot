package com.dom.pelu.repository;

import com.dom.pelu.dto.reporteDTO.ProductoStockBajoDTO;
import com.dom.pelu.dto.reporteDTO.StockPorCategoriaDTO;
import com.dom.pelu.dto.reporteDTO.TopProductoDTO;
import com.dom.pelu.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>
{
    @Query("""
        SELECT new com.dom.pelu.dto.reporteDTO.TopProductoDTO(p.nombre, SUM(dv.cantidad))
        FROM DetalleVenta dv JOIN dv.producto p
        GROUP BY p.nombre
        ORDER BY SUM(dv.cantidad) DESC
        """)
    List<TopProductoDTO> findTop5ProductosMasVendidos();;

    @Query("SELECT new com.dom.pelu.dto.reporteDTO.ProductoStockBajoDTO(p.codigo, p.nombre, p.stock) FROM Producto p WHERE p.stock < 11")
    List<ProductoStockBajoDTO> findProductosConStockBajo();

    @Query("""
        SELECT new com.dom.pelu.dto.reporteDTO.StockPorCategoriaDTO(c.nombre, SUM(p.stock))
        FROM Producto p JOIN p.categorias c
        GROUP BY c.nombre
        """)
    List<StockPorCategoriaDTO> stockPorCategoria();


}
