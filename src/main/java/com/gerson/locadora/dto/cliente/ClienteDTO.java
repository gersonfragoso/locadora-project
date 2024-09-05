package com.gerson.locadora.dto.cliente;

import java.util.Date;

public record ClienteDTO(
        Long id,
        String name,
        Date idade,
        String email,
        String cpf,
        String senha,
        String cnh
){}
