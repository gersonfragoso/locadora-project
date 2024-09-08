package com.gerson.locadora.dto.apolice;

import com.gerson.locadora.dto.aluguel.AluguelDTO;
import com.gerson.locadora.entity.Aluguel;

public record ApoliceDTO(
        Long id,
        Double valorFranquia,
        boolean protecaoTerceiros,
        boolean protecaoCausasNaturais,
        boolean protecaoRoubo,
        Long aluguel
) {
}
