package com.gerson.locadora.dto.usuario;


import com.gerson.locadora.entity.Usuario;

public class UsuarioMapper{
    public static UsuarioDTO usuarioDTO(Usuario usuario){
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getName(),
                usuario.getDataNascimento(),
                usuario.getEmail(),
                usuario.getCpf(),
                usuario.getSenha()
        );
    }
}
