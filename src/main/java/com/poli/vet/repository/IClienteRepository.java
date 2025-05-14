package com.poli.vet.repository;

import com.poli.vet.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {
//    List<Cliente> findAll(); // consultas derivadas
}
