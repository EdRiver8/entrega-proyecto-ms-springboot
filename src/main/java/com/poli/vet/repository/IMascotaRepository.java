package com.poli.vet.repository;

import com.poli.vet.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IMascotaRepository extends JpaRepository<Mascota, Integer> {
    List<Mascota> findMascotaByClienteId(Integer id);

    @Query("SELECT m FROM Mascota m WHERE m.clienteId = :id")
    List<Mascota> encontrarMascotaPorClienteId(Integer id);
}
