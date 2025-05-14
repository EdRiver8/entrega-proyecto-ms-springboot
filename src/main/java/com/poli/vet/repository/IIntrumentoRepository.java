package com.poli.vet.repository;


import com.poli.vet.entity.Instrumento;
import com.poli.vet.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IIntrumentoRepository extends JpaRepository<Instrumento, Integer> {


}
