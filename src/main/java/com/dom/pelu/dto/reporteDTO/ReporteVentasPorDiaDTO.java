package com.dom.pelu.dto.reporteDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReporteVentasPorDiaDTO {
    private LocalDate fecha;
    private Double total;
}