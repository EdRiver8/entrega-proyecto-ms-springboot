package com.dom.pelu.controller;

import com.dom.pelu.dto.VentaDTO;
import com.dom.pelu.entity.Venta;
import com.dom.pelu.service.IVentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

    private final IVentaService ventaService;

    @PostMapping
    public ResponseEntity<Venta> guardarVenta(@Valid @RequestBody VentaDTO ventaDTO) {
        Venta nuevaVenta = ventaService.guardarVenta(ventaDTO);
        return ResponseEntity.ok(nuevaVenta);
    }
}
