package com.dom.pelu.dto;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    private double precio;
    @NotNull(message ="El Stock es obligatorio")
    @Min(value = 0, message = "El Stock no puede ser negativo")
    private Integer stock;

    private Integer codigoCategoria;

    private LocalDate fechaVencimiento;
}
