package com.gerson.locadora.dto.carro;

import com.gerson.locadora.entity.Carro;

public class CarroMapper {
    public static CarroDTO carroToDTO(Carro carro){
        return new CarroDTO(
                carro.getId(),
                carro.getModelo(),
                carro.getPlaca(),
                carro.getChassi(),
                carro.getAcessorios()
        );
    }

}
