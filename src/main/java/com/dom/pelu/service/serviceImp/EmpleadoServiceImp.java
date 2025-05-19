package com.dom.pelu.service.serviceImp;

import com.dom.pelu.dto.EmpleadoDTO;
import com.dom.pelu.entity.Empleado;
import com.dom.pelu.repository.EmpleadoRepository;
import com.dom.pelu.service.IEmpleadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmpleadoServiceImp implements IEmpleadoService {


    private final EmpleadoRepository empleadoRepository;

    @Override
    public Empleado guardarEmpleado(EmpleadoDTO empleadoDTO) {
        if (empleadoDTO.getNombre() == null || empleadoDTO.getNombre().isBlank()) {
            throw new IllegalArgumentException("El nombre del empleado es obligatorio");
        }
        if (empleadoDTO.getApellido1() == null || empleadoDTO.getApellido1().isBlank()) {
            throw new IllegalArgumentException("El primer apellido es obligatorio");
        }

        Empleado empleado = Empleado.builder()
                .documento(empleadoDTO.getDocumento())
                .nombre(empleadoDTO.getNombre())
                .apellido1(empleadoDTO.getApellido1())
                .apellido2(empleadoDTO.getApellido2())
                .build();

        return empleadoRepository.save(empleado);
    }

}
