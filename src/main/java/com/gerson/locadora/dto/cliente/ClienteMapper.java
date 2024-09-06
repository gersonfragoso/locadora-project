package com.gerson.locadora.dto.cliente;

import com.gerson.locadora.entity.Cliente;

public class ClienteMapper {
    public static ClienteDTO clienteToDTO(Cliente cliente){
        return new ClienteDTO(
                cliente.getId(),
                cliente.getName(),
                cliente.getDataNascimento(),
                cliente.getEmail(),
                cliente.getCpf(),
                cliente.getSenha(),
                cliente.getCnh()
        );
    }
}
