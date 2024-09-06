package com.gerson.locadora.controller;


import com.gerson.locadora.dto.apolice.ApoliceDTO;
import com.gerson.locadora.entity.ApoliceSeguro;
import com.gerson.locadora.service.serviceinterface.ApoliceSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apolice")
public class ApoliceSeguroController {
    @Autowired
    public ApoliceSeguroService apoliceSeguroService;

    @PostMapping("/create")
    public ResponseEntity<ApoliceDTO> createApolice(@RequestBody ApoliceSeguro apoliceSeguro){
        ApoliceDTO apoliceDTO = apoliceSeguroService.createApolice(apoliceSeguro);
        return ResponseEntity.ok(apoliceDTO);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ApoliceDTO> updateApolice(@PathVariable Long id, @RequestBody ApoliceSeguro apoliceSeguro){
        ApoliceDTO apoliceDTO = apoliceSeguroService.updateApolice(id,apoliceSeguro);
        return ResponseEntity.ok(apoliceDTO);
    }
}
