package com.dom.pelu.service;

import com.dom.pelu.dto.EmpleadoDTO;
import com.dom.pelu.entity.Empleado;

public interface IEmpleadoService {
    public Empleado guardarEmpleado(EmpleadoDTO empleado);

}
