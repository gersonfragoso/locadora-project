package com.gerson.locadora.dto.aluguel;

import com.gerson.locadora.entity.ApoliceSeguro;
import com.gerson.locadora.entity.Carro;
import com.gerson.locadora.entity.Cliente;
import jakarta.persistence.*;

import java.time.LocalDate;

public record AluguelDTO(
        Long id,
        Long clienteId,
        Long carroId,
        Long apoliceSeguroId,
        LocalDate dataAluguel,
        LocalDate dataDevolucao,
        Double valor
) {}