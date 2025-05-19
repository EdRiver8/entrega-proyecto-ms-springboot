package com.dom.pelu.service.serviceImp;

import com.dom.pelu.dto.DetalleVentaDTO;
import com.dom.pelu.entity.DetalleVenta;
import com.dom.pelu.entity.Producto;
import com.dom.pelu.entity.Venta;
import com.dom.pelu.repository.DetalleVentaRepository;
import com.dom.pelu.repository.ProductoRepository;
import com.dom.pelu.repository.VentaRepository;
import com.dom.pelu.service.IDetalleVentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetalleVentaImp implements IDetalleVentaService {


    private final DetalleVentaRepository detalleVentaRepository;
    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;


    @Override
    public DetalleVenta guardarDetalleVenta(DetalleVentaDTO dto) {
        if (dto.getCantidad() == null || dto.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a cero");
        }

        Producto producto = productoRepository.findById(dto.getCodigoProducto())
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        Venta venta = ventaRepository.findById(dto.getCodigoVenta())
                .orElseThrow(() -> new IllegalArgumentException("Venta no encontrada"));

        if (producto.getStock() < dto.getCantidad()) {
            throw new IllegalStateException("Stock insuficiente para el producto: " + producto.getNombre());
        }

        if (producto.getFechaVencimiento() != null &&
                producto.getFechaVencimiento().isBefore(venta.getFechaVenta())) {
            throw new IllegalStateException("Producto vencido: " + producto.getNombre());
        }

        DetalleVenta detalle = DetalleVenta.builder()
                .venta(venta)
                .producto(producto)
                .cantidad(dto.getCantidad())
                .precioUnitario(producto.getPrecio()) // RN14
                .build();

        producto.setStock(producto.getStock() - dto.getCantidad()); // RN15
        productoRepository.save(producto);

        return detalleVentaRepository.save(detalle);
    }


}
