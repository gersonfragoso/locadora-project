package com.gerson.locadora.controller;

import com.gerson.locadora.dto.cliente.ClienteDTO;
import com.gerson.locadora.entity.Cliente;
import com.gerson.locadora.repository.ClienteRepository;
import com.gerson.locadora.service.serviceinterface.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locadora/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @PostMapping("/create")
    public ResponseEntity<ClienteDTO> createMotorista(@RequestBody Cliente clienteModel) {
        ClienteDTO cliente = this.clienteService.createCliente(clienteModel);
        return new ResponseEntity<ClienteDTO>(cliente, HttpStatus.CREATED);
    }
    @GetMapping("/find/{cpf}")
    public ClienteDTO findCliente(@PathVariable String cpf){
        ClienteDTO cliente = clienteService.findByCpf(cpf);
        return cliente;
    }
}
