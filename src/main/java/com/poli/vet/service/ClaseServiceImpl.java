package com.poli.vet.service;

import com.poli.vet.entity.Clase;

import com.poli.vet.repository.IClaseRepository;
import com.poli.vet.service.interfaces.IClaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseServiceImpl implements IClaseService {

    private final IClaseRepository claseRepository;

    public ClaseServiceImpl(IClaseRepository claseRepository) {
        this.claseRepository = claseRepository;
    }

    @Override
    public List<Clase> obtenerTodas() {
        return claseRepository.findAll();
    }

    @Override
    public Clase obtenerPorId(Integer id) {
        return claseRepository.findById(id).orElse(null);
    }

    @Override
    public Clase crearClase(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public Clase actualizarClase(Integer id, Clase claseActualizada) {
        Clase existente = claseRepository.findById(id).orElseThrow();
        existente.setHorario(claseActualizada.getHorario());
        existente.setInstrumento(claseActualizada.getInstrumento());
        existente.setProfesor(claseActualizada.getProfesor());
        existente.setSala(claseActualizada.getSala());
        return claseRepository.save(existente);
    }

    @Override
    public void eliminarClase(Integer id) {
        claseRepository.deleteById(id);
    }
}
