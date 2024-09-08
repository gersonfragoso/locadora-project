package com.gerson.locadora.service.serviceinterface;

import com.gerson.locadora.dto.aluguel.AluguelDTO;
import com.gerson.locadora.entity.Aluguel;

public interface AluguelService {
    AluguelDTO createAluguel(Aluguel aluguel);
    AluguelDTO updateAluguel(Aluguel aluguel);
}
