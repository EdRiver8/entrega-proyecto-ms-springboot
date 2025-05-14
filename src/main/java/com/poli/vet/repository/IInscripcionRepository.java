package com.poli.vet.repository;

import com.poli.vet.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IInscripcionRepository extends JpaRepository<Inscripcion, Integer> {
    List<Inscripcion> findByAlumnoId(Integer alumnoId);
}
