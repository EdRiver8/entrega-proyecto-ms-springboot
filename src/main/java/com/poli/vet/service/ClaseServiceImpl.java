package com.poli.vet.service;

import com.poli.vet.dto.ClaseDTO;
import com.poli.vet.entity.Clase;

import com.poli.vet.entity.Instrumento;
import com.poli.vet.entity.Profesor;
import com.poli.vet.entity.Sala;
import com.poli.vet.exception.ReglaNegocioException;
import com.poli.vet.repository.IClaseRepository;
import com.poli.vet.repository.IIntrumentoRepository;
import com.poli.vet.repository.IProfesorRepository;
import com.poli.vet.repository.ISalaRepository;
import com.poli.vet.service.interfaces.IClaseService;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;

@Service
public class ClaseServiceImpl implements IClaseService {

    private final IClaseRepository claseRepository;
    private final IProfesorRepository profesorRepository;
    private final ISalaRepository salaRepository;
    private final IIntrumentoRepository intrumentoRepository;
    public ClaseServiceImpl(IClaseRepository claseRepository, IProfesorRepository profesorRepository, ISalaRepository salaRepository, IIntrumentoRepository intrumentoRepository) {
        this.claseRepository = claseRepository;
        this.profesorRepository = profesorRepository;
        this.salaRepository = salaRepository;
        this.intrumentoRepository = intrumentoRepository;
    }

    @Override
    public List<Clase> obtenerTodas() {
        return claseRepository.findAll();
    }


    @Override
    public Clase asignarClaseAProfesor(ClaseDTO claseDTO) {
        LocalDate hoy = LocalDate.now();
        LocalDate inicioSemana = hoy.with(DayOfWeek.MONDAY);
        LocalDate finSemana = hoy.with(DayOfWeek.SUNDAY);

        // Convertir a LocalDateTime para usar en la consulta
        LocalDateTime inicio = inicioSemana.atStartOfDay();
        LocalDateTime fin = finSemana.atTime(LocalTime.MAX);
        System.out.println(inicio);
        long clasesSemana = claseRepository.contarClasesEstaSemana(
                claseDTO.getProfesorId(), inicio, fin
        );
        System.out.println("Profesor ID: " + claseDTO.getProfesorId());
        System.out.println("Clases encontradas esta semana: " + clasesSemana);

        if (clasesSemana >= 5) {
            throw new ReglaNegocioException("El profesor ya tiene 5 clases asignadas esta semana.");
        }

        Profesor profesor = profesorRepository.findById(claseDTO.getProfesorId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Sala sala = salaRepository.findById(claseDTO.getSalaId())
                .orElseThrow(() -> new RuntimeException("Sala no encontrada"));

        Instrumento instrumento = intrumentoRepository.findById(claseDTO.getInstrumentoId())
                .orElseThrow(() -> new RuntimeException("Instrumento no encontrado"));

        Clase nuevaClase = toEntity(claseDTO, profesor, sala, instrumento);
        claseRepository.save(nuevaClase);

        return nuevaClase;
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

    public static Clase toEntity(ClaseDTO dto, Profesor profesor, Sala sala, Instrumento instrumento) {
        Clase clase = new Clase();
        clase.setHorario(dto.getHorario());
        clase.setProfesor(profesor);
        clase.setInstrumento(instrumento); // si aplica
        clase.setSala(sala);        // si aplica
        return clase;
    }
}
