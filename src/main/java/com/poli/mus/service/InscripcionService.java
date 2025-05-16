package com.poli.mus.service;

import com.poli.mus.entity.Alumno;
import com.poli.mus.entity.Clase;
import com.poli.mus.entity.Inscripcion;
import com.poli.mus.repository.AlumnoRepository;
import com.poli.mus.repository.IClaseRepository;
import com.poli.mus.repository.IInscripcionRepository;

import java.util.List;

public class InscripcionService {

    private final IInscripcionRepository inscripcionRepository;
    private final IClaseRepository claseRepository;
    private final AlumnoRepository alumnoRepository;

    public InscripcionService(IInscripcionRepository inscripcionRepository, IClaseRepository claseRepository, AlumnoRepository alumnoRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.claseRepository = claseRepository;
        this.alumnoRepository = alumnoRepository;
    }

    public Inscripcion inscribirAlumnoAClase(Integer alumnoId, Integer claseId) {
        List<Inscripcion> inscripcionesActuales = inscripcionRepository.findByAlumnoId(alumnoId);

        if (inscripcionesActuales.size() >= 3) {
            throw new IllegalStateException("El alumno ya tiene 3 clases activas");
        }

        Alumno alumno = alumnoRepository.findById(alumnoId)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        Clase clase = claseRepository.findById(claseId)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        Inscripcion inscripcion = Inscripcion.builder()
                .alumno(alumno)
                .clase(clase)
                .build();

        return inscripcionRepository.save(inscripcion);
    }
}
