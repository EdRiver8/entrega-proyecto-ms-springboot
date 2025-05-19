package com.dom.pelu.service;

import com.dom.pelu.dto.CategoriaDTO;
import com.dom.pelu.entity.Categoria;

public interface ICategoriaService {
    public Categoria guardarCategoria(CategoriaDTO categoriaDTO);
    public void eliminarCategoria(Integer id);
}
