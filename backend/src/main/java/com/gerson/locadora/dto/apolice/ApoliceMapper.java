package com.gerson.locadora.dto.apolice;

import com.gerson.locadora.entity.ApoliceSeguro;

public class ApoliceMapper {
    public static ApoliceDTO apoliceToDTO(ApoliceSeguro apoliceSeguro){
        return new ApoliceDTO(
                apoliceSeguro.getId(),
                apoliceSeguro.getValorFranquia(),
                apoliceSeguro.getProtecaoTerceiros(),
                apoliceSeguro.getProtecaoCausasNaturais(),
                apoliceSeguro.getProtecaoRoubo(),
                apoliceSeguro.getAluguel() != null ? apoliceSeguro.getAluguel().getId() : null
        );
    }
}
