package com.gerson.locadora.dto.cliente;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record ClienteDTO(
        Long id,
        String name,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        Date dataNascimente,
        String email,
        String cpf,
        String senha,
        String cnh
){}
