package com.gerson.locadora.controller;

import com.gerson.locadora.dto.acessorios.AcessoriosDTO;
import com.gerson.locadora.service.serviceinterface.AcessoriosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acessorios")
public class AcessoriosController {

    @Autowired
    private AcessoriosService acessoriosService;

    @PostMapping("/create")
    public ResponseEntity<List<AcessoriosDTO>> createAcessorios(@RequestBody List<String> nomes) {
        List<AcessoriosDTO> acessoriosDTOList = acessoriosService.createAcessorios(nomes);
        return new ResponseEntity<>(acessoriosDTOList, HttpStatus.CREATED);

    }

    @GetMapping("/listar")
    public ResponseEntity<List<AcessoriosDTO>> listarAcessorios() {
        List<AcessoriosDTO> lista = acessoriosService.listarAcessorios();
        return ResponseEntity.ok(lista);
    }
}