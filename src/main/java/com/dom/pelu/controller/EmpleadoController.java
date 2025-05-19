package com.dom.pelu.controller;

import com.dom.pelu.dto.EmpleadoDTO;
import com.dom.pelu.entity.Empleado;
import com.dom.pelu.service.IEmpleadoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    private final IEmpleadoService empleadoService;


    @PostMapping
    public ResponseEntity<Empleado> guardarEmpleado(@Valid @RequestBody EmpleadoDTO empleado) {
        Empleado nuevoEmpleado =empleadoService.guardarEmpleado(empleado);
        return ResponseEntity.ok(nuevoEmpleado);
    }
}
