package com.gerson.locadora.controller;

import com.gerson.locadora.dto.carro.CarroDTO;
import com.gerson.locadora.entity.Carro;
import com.gerson.locadora.service.serviceinterface.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping("/create")
    public ResponseEntity<CarroDTO> createCarro(@RequestBody CarroDTO carroDTO) {
        CarroDTO carroCriado = carroService.createCarro(carroDTO);
        return new ResponseEntity<>(carroCriado, HttpStatus.CREATED);
    }

    @PutMapping("/update/{placa}")
    public ResponseEntity<CarroDTO> updateCarro(@PathVariable String placa, @RequestBody Carro carro) {
        CarroDTO carroAtualizado = carroService.updateCarro(placa, carro);
        return ResponseEntity.ok(carroAtualizado);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<CarroDTO>> listCarros(){
        List<CarroDTO> lista = carroService.listarCarros();
        return ResponseEntity.ok(lista);
    }
}
