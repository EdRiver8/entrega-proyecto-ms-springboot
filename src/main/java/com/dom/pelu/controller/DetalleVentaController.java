package com.dom.pelu.controller;

import com.dom.pelu.dto.DetalleVentaDTO;
import com.dom.pelu.entity.DetalleVenta;
import com.dom.pelu.service.IDetalleVentaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/detalles")
@RequiredArgsConstructor
public class DetalleVentaController {

    private final IDetalleVentaService detalleVentaService;

    @PostMapping
    public ResponseEntity<DetalleVenta> guardarDetalle(@Valid @RequestBody DetalleVentaDTO detalleDTO) {
        DetalleVenta detalle = detalleVentaService.guardarDetalleVenta(detalleDTO);
        return ResponseEntity.ok(detalle);
    }

}
