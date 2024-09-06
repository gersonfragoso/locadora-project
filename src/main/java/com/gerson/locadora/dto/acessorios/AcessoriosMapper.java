package com.gerson.locadora.dto.acessorios;

import com.gerson.locadora.entity.Acessorios;

public class AcessoriosMapper {
    public static AcessoriosDTO acessoriosToDTO(Acessorios acessorios){
        return new AcessoriosDTO(
                acessorios.getId(),
                acessorios.getName()
        );
    }
}
