package com.poli.vet.service;

import com.poli.vet.entity.Cliente;
import com.poli.vet.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IClienteService {
    void eliminarCliente(Integer id);
    void guardarCliente(Integer id);
    Cliente obtenerClientePorId(Integer id);
    List<Cliente> obtenerClientes();
}
