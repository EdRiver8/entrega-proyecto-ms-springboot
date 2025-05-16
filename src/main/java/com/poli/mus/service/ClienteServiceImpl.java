package com.poli.mus.service;

import com.poli.mus.entity.Cliente;
import com.poli.mus.entity.Mascota;
import com.poli.mus.repository.IClienteRepository;
import com.poli.mus.repository.IMascotaRepository;
import com.poli.mus.service.interfaces.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {
    // usamos inyeccion de dependencias
    @Autowired
    private IClienteRepository clienteRepository;
    @Autowired
    private IMascotaRepository mascotaRepository;

    @Override
    public void eliminarCliente(Integer id) {

    }

    @Override
    public void guardarCliente(Integer id) {

    }

    public Cliente obtenerClientePorId2(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if(cliente == null){
            return null;
        }
        return cliente;
    }

    @Override
    public Cliente obtenerClientePorId(Integer id) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if(cliente == null){
            return null;
        }
        // buscamos en mascotas los clientes cuyo cliente_id = id
        List<Mascota> mascotas = mascotaRepository.findMascotaByClienteId(id);
        cliente.setMascotas(mascotas);
        return cliente;
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }
}
