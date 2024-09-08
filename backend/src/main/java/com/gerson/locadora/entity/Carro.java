package com.gerson.locadora.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String placa;
    private String chassi;
    @ManyToMany
    @JoinTable(
            name = "carro_acessorios",
            joinColumns = @JoinColumn(name = "carro_id"),
            inverseJoinColumns = @JoinColumn(name = "acessorio_id")
    )
    private List<Acessorios> acessorios;

}
