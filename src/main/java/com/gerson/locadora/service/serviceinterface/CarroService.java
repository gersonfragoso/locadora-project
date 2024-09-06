package com.gerson.locadora.service.serviceinterface;

import com.gerson.locadora.dto.carro.CarroDTO;
import com.gerson.locadora.entity.Carro;

import java.util.List;

public interface CarroService {
    CarroDTO createCarro(CarroDTO carroDTO);
    List<CarroDTO> listarCarros();
    CarroDTO updateCarro(String placa, Carro carro);
}
