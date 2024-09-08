package com.gerson.locadora.controller;

import com.gerson.locadora.dto.aluguel.AluguelDTO;
import com.gerson.locadora.entity.Aluguel;
import com.gerson.locadora.service.serviceinterface.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    public AluguelService aluguelService;
    @PostMapping("create")
    public ResponseEntity<AluguelDTO> createAluguel(@RequestBody Aluguel aluguel) {
        return ResponseEntity.ok(aluguelService.createAluguel(aluguel));
    }

}
