package com.gerson.locadora.dto.carro;

import com.gerson.locadora.entity.Acessorios;
import com.gerson.locadora.entity.Carro;

import java.util.List;
import java.util.stream.Collectors;

public class CarroMapper {
    public static CarroDTO carroToDTO(Carro carro){
        List<String> acessoriosNomes = carro.getAcessorios().stream()
                .map(Acessorios::getName)
                .collect(Collectors.toList());
        return new CarroDTO(
                carro.getId(),
                carro.getModelo(),
                carro.getPlaca(),
                carro.getChassi(),
                acessoriosNomes
        );
    }

}
