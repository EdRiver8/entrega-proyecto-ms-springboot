package com.dom.pelu.dto.reporteDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TopProductoDTO {
    private String nombreProducto;
    private Long cantidadVendida;
}
