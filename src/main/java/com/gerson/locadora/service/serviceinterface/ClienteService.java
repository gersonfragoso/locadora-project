package com.gerson.locadora.service.serviceinterface;

import com.gerson.locadora.dto.cliente.ClienteDTO;
import com.gerson.locadora.entity.Cliente;

public interface ClienteService {
    ClienteDTO createCliente(Cliente cliente);
    ClienteDTO updateCliente(Cliente cliente);
    ClienteDTO deleteCliente(String cpf);
}
