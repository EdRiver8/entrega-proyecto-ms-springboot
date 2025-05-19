package com.dom.pelu.service;

import com.dom.pelu.dto.DetalleVentaDTO;
import com.dom.pelu.entity.DetalleVenta;


public interface IDetalleVentaService {
    public DetalleVenta guardarDetalleVenta(DetalleVentaDTO dto);
}
