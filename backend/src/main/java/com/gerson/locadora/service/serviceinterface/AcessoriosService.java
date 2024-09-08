package com.gerson.locadora.service.serviceinterface;

import com.gerson.locadora.dto.acessorios.AcessoriosDTO;
import com.gerson.locadora.entity.Acessorios;

import java.util.List;

public interface AcessoriosService {
    List<AcessoriosDTO> createAcessorios(List<String>acessorios);
    List<AcessoriosDTO> listarAcessorios();
}
