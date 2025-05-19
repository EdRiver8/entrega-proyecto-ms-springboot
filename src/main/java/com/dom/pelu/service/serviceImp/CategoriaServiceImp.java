package com.dom.pelu.service.serviceImp;

import com.dom.pelu.dto.CategoriaDTO;
import com.dom.pelu.entity.Categoria;
import com.dom.pelu.repository.CategoriaRepository;
import com.dom.pelu.service.ICategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaServiceImp implements ICategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Override
    public Categoria guardarCategoria(CategoriaDTO categoriaDTO) {
        boolean existe = categoriaRepository.findAll().stream()
                .anyMatch(c -> c.getNombre().equalsIgnoreCase(categoriaDTO.getNombre()));
        if (existe) {
            throw new IllegalArgumentException("El nombre de la categoría ya existe");
        }

        Categoria categoria = Categoria.builder()
                .nombre(categoriaDTO.getNombre())
                .build();

        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoría no encontrada"));

        if (categoria.getProductos() != null && !categoria.getProductos().isEmpty()) {
            throw new IllegalStateException("No se puede eliminar una categoría con productos asignados");
        }

        categoriaRepository.delete(categoria);
    }

}
