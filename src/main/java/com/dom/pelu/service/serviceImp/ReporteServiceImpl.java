package com.dom.pelu.service.serviceImp;
import com.dom.pelu.dto.reporteDTO.*;
import com.dom.pelu.repository.EmpleadoRepository;
import com.dom.pelu.repository.ProductoRepository;
import com.dom.pelu.repository.VentaRepository;
import com.dom.pelu.service.IReporteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReporteServiceImpl implements IReporteService {

    private final ProductoRepository productoRepo;
    private final VentaRepository ventaRepo;
    private final EmpleadoRepository empleadoRepo;
    @Override
    public List<TopProductoDTO> top5ProductosMasVendidos() {
        return productoRepo.findTop5ProductosMasVendidos()
                .stream()
                .limit(5)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmpleadoVentaDTO> empleadosConVentas() {
        return empleadoRepo.empleadosConVentas();
    }


    @Override
    public List<ProductoStockBajoDTO> productosConStockBajo() {
        return productoRepo.findProductosConStockBajo();
    }

    @Override
    public List<StockPorCategoriaDTO> stockPorCategoria() {
        return productoRepo.stockPorCategoria();
    }

    @Override
    public List<ReporteVentasPorDiaDTO> totalVentasPorDia() {
        return ventaRepo.totalVentasPorDia();
    }
}
