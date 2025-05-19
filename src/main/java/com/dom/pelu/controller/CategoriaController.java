package com.dom.pelu.controller;

import com.dom.pelu.dto.CategoriaDTO;
import com.dom.pelu.entity.Categoria;
import com.dom.pelu.service.ICategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final ICategoriaService categoriaService;


    @PostMapping
    public ResponseEntity<Categoria> guardarCategoria(@Valid @RequestBody CategoriaDTO categoriaDTO) {
        Categoria nuevaCategoria = categoriaService.guardarCategoria(categoriaDTO);
        return ResponseEntity.ok(nuevaCategoria);
    }
}
