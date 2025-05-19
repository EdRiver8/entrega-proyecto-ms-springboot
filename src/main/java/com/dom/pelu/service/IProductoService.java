package com.dom.pelu.service;

import com.dom.pelu.dto.ProductoDTO;
import com.dom.pelu.entity.Producto;

public interface IProductoService {

    public Producto guardarProducto(ProductoDTO productoDTO);
}
