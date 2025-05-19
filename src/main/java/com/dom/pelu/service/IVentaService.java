package com.dom.pelu.service;

import com.dom.pelu.dto.VentaDTO;
import com.dom.pelu.entity.Venta;

public interface IVentaService {
    public Venta guardarVenta(VentaDTO ventaDTO);
}
