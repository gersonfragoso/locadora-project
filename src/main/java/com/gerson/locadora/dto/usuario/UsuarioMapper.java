package com.gerson.locadora.dto.usuario;


import com.gerson.locadora.entity.Usuario;

import java.util.Date;

public class UsuarioMapper{
    public static UsuarioDTO usuarioDTO(Usuario usuario){
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getName(),
                usuario.getIdade(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getSenha()
        );
    }
}
