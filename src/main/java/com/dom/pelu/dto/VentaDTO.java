package com.dom.pelu.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {

    @NotNull(message = "La fecha  es obligatorio")
    private LocalDate fechaVenta;
    @Min(value = 0, message = "El total de la venta no puede ser negativo")
    private double totalVenta;
    @NotNull(message = "El documento el empleado es obligatorio")
    private Integer docuemntoEmpleado;
}
