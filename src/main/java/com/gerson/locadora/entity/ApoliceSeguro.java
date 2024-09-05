package com.gerson.locadora.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApoliceSeguro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorFranquia;
    private Boolean protecaoTerceiros;
    private Boolean protecaoCausasNaturais;
    private Boolean protecaoRoubo;

    @OneToOne(mappedBy = "apoliceSeguro")
    private Aluguel aluguel;
}

