package com.dom.pelu.dto;

import com.dom.pelu.entity.Producto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetalleVentaDTO {
    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private Integer cantidad;
    @NotNull(message = "El Codigo de la venta no estar vacio")
    private Integer codigoVenta;
    @NotNull(message = "El codigo del el producto no puede estar vacio")
    private Integer codigoProducto;
}
