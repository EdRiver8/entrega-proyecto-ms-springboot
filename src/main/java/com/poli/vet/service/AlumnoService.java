package com.poli.vet.service;

import com.poli.vet.dto.AlumnoDTO;
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

    public Alumno guardar(AlumnoDTO dto) {
        if (dto.getEdad() < 7) {
            throw new IllegalArgumentException("La edad mínima es 7 años");
        }

        Alumno alumno = Alumno.builder()
                .nombre(dto.getNombre())
                .correo(dto.getCorreo())
                .edad(dto.getEdad())
                .nivel(dto.getNivel())
                .build();

        return alumnoRepository.save(alumno);
    }

    public List<Alumno> listar() {
        return alumnoRepository.findAll();
    }
}
