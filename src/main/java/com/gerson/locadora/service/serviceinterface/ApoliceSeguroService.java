package com.gerson.locadora.service.serviceinterface;

import com.gerson.locadora.dto.apolice.ApoliceDTO;
import com.gerson.locadora.entity.ApoliceSeguro;

public interface ApoliceSeguroService {
    ApoliceDTO createApolice(ApoliceSeguro apoliceSeguro);

    ApoliceDTO updateApolice(Long id, ApoliceSeguro apoliceSeguro);
}
