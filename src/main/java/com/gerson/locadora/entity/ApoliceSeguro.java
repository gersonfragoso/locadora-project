package com.gerson.locadora.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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

