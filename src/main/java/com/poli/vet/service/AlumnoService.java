package com.poli.vet.service;

import com.poli.vet.entity.Alumno;
import com.poli.vet.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    public AlumnoService(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    public Alumno guardar(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> listar() {
        return alumnoRepository.findAll();
    }
}
