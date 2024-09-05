package com.gerson.locadora.dto.aluguel;

import com.gerson.locadora.entity.Aluguel;

public class AluguelMapper {
    public static AluguelDTO aluguelToDTO(Aluguel aluguel) {
        return new AluguelDTO(
                aluguel.getId(),
                aluguel.getCliente() != null ? aluguel.getCliente().getId() : null,
                aluguel.getCarro() != null ? aluguel.getCarro().getId() : null,
                aluguel.getApoliceSeguro() != null ? aluguel.getApoliceSeguro().getId() : null,
                aluguel.getDataAluguel(),
                aluguel.getDataDevolucao(),
                aluguel.getValor()
        );
    }
}
