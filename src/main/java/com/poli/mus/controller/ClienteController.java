package com.poli.mus.controller;

import com.poli.mus.entity.Cliente;
import com.poli.mus.service.IClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    private final IClienteService clienteService;

    public ClienteController(IClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/salud")
    public String salud(){
        return "Estoy OK!";
    }

    @GetMapping("/todos")
    public List<Cliente> listarClientes(){
        return clienteService.obtenerClientes();
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable Integer id){
        return clienteService.obtenerClientePorId(id);
    }

    @GetMapping("/mascota/{id}")
    public Cliente obtenerClientePorIdConMascotas(@PathVariable Integer id){
        return clienteService.obtenerClientePorId(id);
    }
}
