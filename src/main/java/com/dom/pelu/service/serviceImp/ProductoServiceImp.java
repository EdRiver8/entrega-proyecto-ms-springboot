package com.dom.pelu.service.serviceImp;

import com.dom.pelu.dto.ProductoDTO;
import com.dom.pelu.entity.Categoria;
import com.dom.pelu.entity.Producto;
import com.dom.pelu.repository.CategoriaRepository;
import com.dom.pelu.repository.ProductoRepository;
import com.dom.pelu.service.IProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoServiceImp implements IProductoService {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

    @Override
    public Producto guardarProducto(ProductoDTO productoDTO) {
        if (productoDTO.getNombre() == null || productoDTO.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del producto es obligatorio");
        }
        if (productoDTO.getPrecio() < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        if (productoDTO.getStock() < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo");
        }
        if (productoDTO.getCodigoCategoria() == null) {
            throw new IllegalArgumentException("Debe asignarse una categoría al producto");
        }

        Categoria categoria = categoriaRepository.findById(productoDTO.getCodigoCategoria())
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        Producto producto = Producto.builder()
                .nombre(productoDTO.getNombre())
                .precio(productoDTO.getPrecio())
                .stock(productoDTO.getStock())
                .fechaVencimiento(productoDTO.getFechaVencimiento())
                .categorias(List.of(categoria))
                .build();

        return productoRepository.save(producto);
    }

    public boolean productoPuedeVenderse(Producto producto) {
        return producto.getStock() > 0;
    }

}
