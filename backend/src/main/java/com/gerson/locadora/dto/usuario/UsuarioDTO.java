package com.gerson.locadora.dto.usuario;

import java.util.Date;

public record UsuarioDTO(
        Long id,
        String nome,
        Date idade,
        String email,
        String cpf,
        String senha) {
}
