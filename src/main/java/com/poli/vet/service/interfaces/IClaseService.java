package com.poli.vet.service.interfaces;

import com.poli.vet.dto.ClaseDTO;
import com.poli.vet.entity.Clase;

import java.util.List;

public interface IClaseService {
    List<Clase> obtenerTodas();

    Clase asignarClaseAProfesor(ClaseDTO claseDTO);

    Clase obtenerPorId(Integer id);
    Clase crearClase(Clase clase);
    Clase actualizarClase(Integer id, Clase claseActualizada);
    void eliminarClase(Integer id);
}
