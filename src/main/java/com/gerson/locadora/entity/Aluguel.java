package com.gerson.locadora.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "carro_id")
    private Carro carro;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seguro_id", referencedColumnName = "id")
    private ApoliceSeguro apoliceSeguro;
    private LocalDate dataAluguel;
    private LocalDate dataDevolucao;
    private Double valor;
}
