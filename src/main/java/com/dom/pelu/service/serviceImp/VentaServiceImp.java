package com.dom.pelu.service.serviceImp;

import com.dom.pelu.dto.VentaDTO;
import com.dom.pelu.entity.Empleado;
import com.dom.pelu.entity.Venta;
import com.dom.pelu.repository.EmpleadoRepository;
import com.dom.pelu.repository.VentaRepository;
import com.dom.pelu.service.IVentaService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VentaServiceImp implements IVentaService {

    private final VentaRepository ventaRepository;
    private final EmpleadoRepository empleadoRepository;



    @Override
    public Venta guardarVenta(VentaDTO ventaDTO) {
        Empleado empleado = empleadoRepository.findById(ventaDTO.getDocuemntoEmpleado())
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado")); // RN1 y RN9


        Venta venta = Venta.builder()
                .fechaVenta(ventaDTO.getFechaVenta())
                .empleado(empleado)
                .build();

        venta = ventaRepository.save(venta);

        double totalVenta = 0.0;

        venta.setTotalVenta(totalVenta);
        return ventaRepository.save(venta);
    }

}

