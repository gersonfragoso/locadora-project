package com.gerson.locadora.service.serviceimpl;


import com.gerson.locadora.dto.carro.CarroDTO;
import com.gerson.locadora.dto.carro.CarroMapper;
import com.gerson.locadora.entity.Acessorios;
import com.gerson.locadora.entity.Carro;
import com.gerson.locadora.repository.AcessoriosRepository;
import com.gerson.locadora.repository.CarroRepository;
import com.gerson.locadora.service.serviceinterface.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroServiceImpl implements CarroService{

    @Autowired
    public CarroRepository carroRepository;
    @Autowired
    private AcessoriosRepository acessoriosRepository;

    @Override
    public CarroDTO createCarro(CarroDTO carroDTO) {
        List<Acessorios> acessoriosList = carroDTO.acessorios().stream()
                .map(name -> {
                    Optional<Acessorios> acessorio = acessoriosRepository.findByName(String.valueOf(name));
                    if (acessorio.isPresent()) {
                        return acessorio.get();
                    } else {
                        throw new RuntimeException("Acessório não encontrado com o nome: " + name);
                    }
                })
                .collect(Collectors.toList());

        Carro carro = new Carro();
        carro.setModelo(carroDTO.modelo());
        carro.setPlaca(carroDTO.placa());
        carro.setChassi(carroDTO.chassi());
        carro.setAcessorios(acessoriosList);

        Carro carroSalvo = carroRepository.save(carro);
        return CarroMapper.carroToDTO(carroSalvo);
    }

    @Override
    public List<CarroDTO> listarCarros() {
        List<Carro> carros = carroRepository.findAll();
        return carros.stream()
                .map(CarroMapper::carroToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CarroDTO updateCarro(String placa, Carro carro) {
        Carro carroExistente = carroRepository.findByPlaca(placa)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com a placa: " + placa));

        if (carro.getModelo() != null && !carro.getModelo().isEmpty()) {
            carroExistente.setModelo(carro.getModelo());
        }
        if (carro.getChassi() != null && !carro.getChassi().isEmpty()) {
            carroExistente.setChassi(carro.getChassi());
        }
        if (carro.getAcessorios() != null && !carro.getAcessorios().isEmpty()) {
            carroExistente.setAcessorios(carro.getAcessorios());
        }
        Carro carroAtualizado = carroRepository.save(carroExistente);
        return CarroMapper.carroToDTO(carroAtualizado);
    }

}
