package com.gerson.locadora.service.serviceimpl;

import com.gerson.locadora.dto.aluguel.AluguelDTO;
import com.gerson.locadora.dto.aluguel.AluguelMapper;
import com.gerson.locadora.entity.Aluguel;
import com.gerson.locadora.entity.ApoliceSeguro;
import com.gerson.locadora.entity.Carro;
import com.gerson.locadora.entity.Cliente;
import com.gerson.locadora.repository.AluguelRepository;
import com.gerson.locadora.repository.ApoliceRepository;
import com.gerson.locadora.repository.CarroRepository;
import com.gerson.locadora.repository.ClienteRepository;
import com.gerson.locadora.service.serviceinterface.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    public AluguelRepository aluguelRepository;
    @Autowired
    public ClienteRepository clienteRepository;
    @Autowired
    public CarroRepository carroRepository;
    @Autowired
    public ApoliceRepository apoliceRepository;
    @Override
    public AluguelDTO createAluguel(Aluguel aluguel) {
        Cliente cliente = clienteRepository.findByCpf(aluguel.getCliente().getCpf())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o ID: " + aluguel.getCliente().getCpf()));
        Carro carro = carroRepository.findByPlaca(aluguel.getCarro().getPlaca())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com o ID: " + aluguel.getCarro().getPlaca()));
        ApoliceSeguro apoliceSeguro = apoliceRepository.findById(aluguel.getApoliceSeguro().getId())
                .orElseThrow(() -> new RuntimeException("Apólice de Seguro não encontrada com o ID: " + (aluguel.getApoliceSeguro().getId())));
        Aluguel aluguel1 = new Aluguel();
        aluguel1.setCliente(cliente);
        aluguel1.setCarro(carro);
        aluguel1.setApoliceSeguro(apoliceSeguro);
        aluguel1.setDataAluguel(aluguel.getDataAluguel());
        aluguel1.setDataDevolucao(aluguel.getDataDevolucao());
        aluguel1.setValor(aluguel.getValor());
        aluguelRepository.save(aluguel1);
        return AluguelMapper.aluguelToDTO(aluguel1);
    }

    @Override
    public AluguelDTO updateAluguel(Aluguel aluguel) {
        return null;
    }
}
