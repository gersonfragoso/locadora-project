package com.gerson.locadora.service.serviceimpl;

import com.gerson.locadora.dto.acessorios.AcessoriosDTO;
import com.gerson.locadora.dto.acessorios.AcessoriosMapper;
import com.gerson.locadora.entity.Acessorios;
import com.gerson.locadora.repository.AcessoriosRepository;
import com.gerson.locadora.service.serviceinterface.AcessoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AcessoriosServiceImpl implements AcessoriosService {

    @Autowired
    public AcessoriosRepository acessoriosRepository;
    @Override
    public List<AcessoriosDTO> createAcessorios(List<String> nomes) {

        List<Acessorios> acessoriosList = nomes.stream()
                .map(nome -> {
                    Optional<Acessorios> existe = acessoriosRepository.findByName(nome);
                    return existe.orElseGet(() -> acessoriosRepository.save(new Acessorios(null, nome)));
                })
                .collect(Collectors.toList());
        return acessoriosList.stream()
                .map(AcessoriosMapper::acessoriosToDTO)
                .collect(Collectors.toList());
    }
    public List<AcessoriosDTO> listarAcessorios(){
        List<Acessorios>lista = acessoriosRepository.findAll();
        return lista.stream().map(AcessoriosMapper::acessoriosToDTO).collect(Collectors.toList());
    }
}
