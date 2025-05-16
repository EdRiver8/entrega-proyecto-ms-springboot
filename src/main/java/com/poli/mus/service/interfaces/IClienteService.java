package com.poli.mus.service.interfaces;

import com.poli.mus.entity.Cliente;

import java.util.List;

public interface IClienteService {
    void eliminarCliente(Integer id);
    void guardarCliente(Integer id);
    Cliente obtenerClientePorId(Integer id);
    List<Cliente> obtenerClientes();
}
