package com.poli.vet.repository;

import com.poli.vet.entity.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IClaseRepository extends JpaRepository<Clase, Integer> {
    @Query("SELECT COUNT(*) FROM Clase c WHERE c.profesor.id = :profesorId AND c.horario BETWEEN :inicioSemana AND :finSemana")
    long contarClasesEstaSemana(
            @Param("profesorId") Integer profesorId,
            @Param("inicioSemana") java.time.LocalDateTime inicioSemana,
            @Param("finSemana") java.time.LocalDateTime finSemana
    );

}
