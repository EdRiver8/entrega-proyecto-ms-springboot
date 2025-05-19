package com.dom.pelu.service;

import com.dom.pelu.dto.reporteDTO.*;

import java.util.List;

public interface IReporteService {

    List<TopProductoDTO> top5ProductosMasVendidos();
    List<EmpleadoVentaDTO> empleadosConVentas();
    List<ProductoStockBajoDTO> productosConStockBajo();
    List<StockPorCategoriaDTO> stockPorCategoria();
    List<ReporteVentasPorDiaDTO> totalVentasPorDia();
}
