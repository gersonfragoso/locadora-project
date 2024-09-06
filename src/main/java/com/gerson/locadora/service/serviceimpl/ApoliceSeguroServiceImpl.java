package com.gerson.locadora.service.serviceimpl;

import com.gerson.locadora.dto.apolice.ApoliceDTO;
import com.gerson.locadora.dto.apolice.ApoliceMapper;
import com.gerson.locadora.entity.ApoliceSeguro;
import com.gerson.locadora.repository.ApoliceRepository;
import com.gerson.locadora.service.serviceinterface.ApoliceSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ApoliceSeguroServiceImpl implements ApoliceSeguroService {

    @Autowired
    public ApoliceRepository apoliceRepository;
    @Override
    public ApoliceDTO createApolice(ApoliceSeguro apoliceSeguro) {
        ApoliceSeguro apoliceDTO = apoliceRepository.save(apoliceSeguro);
        return ApoliceMapper.apoliceToDTO(apoliceDTO);
    }

    @Override
    public ApoliceDTO updateApolice(Long id, ApoliceSeguro apoliceSeguro) {
        ApoliceSeguro apolice = apoliceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apólice não encontrada com o ID: " + id));
        if (apoliceSeguro.getValorFranquia() != null) {
            apolice.setValorFranquia(apolice.getValorFranquia());
        }
        if (apoliceSeguro.getProtecaoTerceiros() != null) {
            apolice.setProtecaoTerceiros(apoliceSeguro.getProtecaoTerceiros());
        }
        if (apoliceSeguro.getProtecaoCausasNaturais() != null) {
            apolice.setProtecaoCausasNaturais(apoliceSeguro.getProtecaoCausasNaturais());
        }
        if (apoliceSeguro.getProtecaoRoubo() != null) {
            apolice.setProtecaoRoubo(apoliceSeguro.getProtecaoRoubo());
        }
        apoliceRepository.save(apolice);
        return ApoliceMapper.apoliceToDTO(apolice);
    }
}
