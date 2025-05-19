package com.dom.pelu.dto.reporteDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoStockBajoDTO {
    private Integer codigo;
    private String nombre;
    private Integer stock;
}
