package com.poli.vet.service;

import com.poli.vet.dto.ProfesorDTO;
import com.poli.vet.entity.Profesor;

import com.poli.vet.exception.ReglaNegocioException;
import com.poli.vet.repository.IClaseRepository;
import com.poli.vet.repository.IProfesorRepository;
import com.poli.vet.repository.ISalaRepository;
import com.poli.vet.service.interfaces.IProfesorService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProfesorServiceImpl implements IProfesorService {

    private final IProfesorRepository profesorRepository;
    private final IClaseRepository claseRepository;

    public ProfesorServiceImpl(IProfesorRepository profesorRepository, IClaseRepository claseRepository, ISalaRepository salaRepository) {
        this.profesorRepository = profesorRepository;
        this.claseRepository = claseRepository;
    }

    @Override
    public List<Profesor> obtenerTodos() {
        return profesorRepository.findAll();
    }

    @Override
    public Profesor obtenerPorId(Integer id) {
        return profesorRepository.findById(id).orElse(null);
    }

    @Override
    public Profesor crear(ProfesorDTO dto) {

        Profesor profesor = dtoToEntity(dto);
        return profesorRepository.save(profesor);
    }


    @Override
    public Profesor actualizar(Integer id, Profesor actualizado) {
        Profesor existente = profesorRepository.findById(id).orElseThrow();
        existente.setNombre(actualizado.getNombre());
        existente.setEspecialidad(actualizado.getEspecialidad());
        existente.setDisponibilidad(actualizado.getDisponibilidad());
        return profesorRepository.save(existente);
    }

    @Override
    public void eliminar(Integer id) {
        profesorRepository.deleteById(id);
    }
    private Profesor dtoToEntity(ProfesorDTO dto) {
        return Profesor.builder()
                .id(dto.getId())
                .nombre(dto.getNombre())
                .especialidad(dto.getEspecialidad())
                .disponibilidad(dto.getDisponibilidad())
                .build();
    }
}
