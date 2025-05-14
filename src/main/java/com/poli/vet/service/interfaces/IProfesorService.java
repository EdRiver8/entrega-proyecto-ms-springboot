package com.poli.vet.service.interfaces;

import com.poli.vet.dto.ProfesorDTO;
import com.poli.vet.entity.Profesor;

import java.util.List;

public interface IProfesorService {
    List<Profesor> obtenerTodos();
    Profesor obtenerPorId(Integer id);
    Profesor crear(ProfesorDTO profesor);
    Profesor actualizar(Integer id, Profesor actualizado);
    void eliminar(Integer id);
}
