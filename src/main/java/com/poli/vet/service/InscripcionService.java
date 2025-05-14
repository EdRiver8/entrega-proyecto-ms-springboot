package com.poli.vet.service;

import com.poli.vet.entity.Alumno;
import com.poli.vet.entity.Clase;
import com.poli.vet.entity.Inscripcion;
import com.poli.vet.repository.AlumnoRepository;
import com.poli.vet.repository.IClaseRepository;
import com.poli.vet.repository.IInscripcionRepository;

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
