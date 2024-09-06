package com.gerson.locadora.dto.admin;

import com.gerson.locadora.entity.Admin;

public class AdminMapper {
    public static AdminDTO adminToDTO(Admin admin){
        return new AdminDTO(
                admin.getId(),
                admin.getName(),
                admin.getDataNascimento(),
                admin.getEmail(),
                admin.getCpf(),
                admin.getSenha(),
                admin.getMatricula()
        );
    }
}
