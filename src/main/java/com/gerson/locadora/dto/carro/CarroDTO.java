package com.gerson.locadora.dto.carro;

import com.gerson.locadora.entity.Acessorios;

import java.util.List;

public record CarroDTO(Long id, String modelo, String placa, String chassi, List<Acessorios> acessorios) {
}
