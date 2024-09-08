package com.gerson.locadora.dto.admin;

import java.util.Date;

public record AdminDTO(
        Long id,
        String name,
        Date idade,
        String email,
        String cpf,
        String senha,
        String matricula
) {}
