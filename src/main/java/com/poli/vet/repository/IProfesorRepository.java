package com.poli.vet.repository;

import com.poli.vet.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorRepository extends JpaRepository<Profesor, Integer> {
}
