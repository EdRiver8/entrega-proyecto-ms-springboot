package com.dom.pelu.controller;

import com.dom.pelu.dto.ProductoDTO;
import com.dom.pelu.entity.Producto;
import com.dom.pelu.service.serviceImp.ProductoServiceImp;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController{

    private final ProductoServiceImp productoService;

    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@Valid @RequestBody ProductoDTO productoDTO) {
        Producto nuevoProducto = productoService.guardarProducto(productoDTO);
        return ResponseEntity.ok(nuevoProducto);
    }
}
