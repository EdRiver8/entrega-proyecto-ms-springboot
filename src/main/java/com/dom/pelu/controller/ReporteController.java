package com.dom.pelu.controller;


import com.dom.pelu.dto.reporteDTO.*;
import com.dom.pelu.service.IReporteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@AllArgsConstructor
public class ReporteController {

    private IReporteService reporteService;

    @GetMapping("/productos/top5")
    public List<TopProductoDTO> top5() {
        return reporteService.top5ProductosMasVendidos();
    }
    @GetMapping("/empleados/ventas")
    public List<EmpleadoVentaDTO> empleadosConVentas() {
        return reporteService.empleadosConVentas();
    }
    @GetMapping("/productos/stock-bajo")
    public List<ProductoStockBajoDTO> stockBajo() {
        return reporteService.productosConStockBajo();
    }
    @GetMapping("/stock/categoria")
    public List<StockPorCategoriaDTO> stockPorCategoria() {
        return reporteService.stockPorCategoria();
    }
    @GetMapping("/ventas/por-dia")
    public List<ReporteVentasPorDiaDTO> ventasPorDia() {
        return reporteService.totalVentasPorDia();
    }
}
