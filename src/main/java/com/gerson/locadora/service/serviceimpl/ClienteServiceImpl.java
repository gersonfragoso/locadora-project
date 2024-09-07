package com.gerson.locadora.service.serviceimpl;

import com.gerson.locadora.dto.cliente.ClienteDTO;
import com.gerson.locadora.dto.cliente.ClienteMapper;
import com.gerson.locadora.entity.Cliente;
import com.gerson.locadora.repository.ClienteRepository;
import com.gerson.locadora.service.serviceinterface.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;



    @Override
    public ClienteDTO createCliente(Cliente cliente) {
        VerificaCliente(clienteRepository.findByCpf(cliente.getCpf()), "Cliente com este CPF já existe");
        VerificaCliente(clienteRepository.findByEmail(cliente.getEmail()), "Cliente com este email já existe");
        VerificaCliente(clienteRepository.findByCnh(cliente.getCnh()), "Cliente com esta CNH já existe");
        Cliente clienteSave = clienteRepository.save(cliente);
        return ClienteMapper.clienteToDTO(clienteSave);
    }

    @Override
    public ClienteDTO updateCliente(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByCpf(cliente.getCpf())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o CPF: " + cliente.getCpf()));
        if (cliente.getName() != null && !cliente.getName().isEmpty()){
            clienteExistente.setName(cliente.getName());
        }if (cliente.getDataNascimento() != null){
            clienteExistente.setDataNascimento(cliente.getDataNascimento());
        }if (cliente.getCnh() != null && !cliente.getCnh().isEmpty()){
            clienteExistente.setCnh(cliente.getCnh());
        }if (cliente.getEmail() != null && !cliente.getEmail().isEmpty()){
            clienteExistente.setEmail(cliente.getEmail());
        }if (cliente.getSenha() != null && !cliente.getSenha().isEmpty()){
            clienteExistente.setSenha(cliente.getSenha());
        }
        Cliente clienteAtualizado = clienteRepository.save(clienteExistente);

        return ClienteMapper.clienteToDTO(clienteAtualizado);
    }

    @Override
    public ClienteDTO deleteCliente(String cpf) {
        Cliente clienteExistente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o CPF: " + cpf));
        clienteRepository.delete(clienteExistente);
        return ClienteMapper.clienteToDTO(clienteExistente);
    }
    @Override
    public ClienteDTO findByCpf(String cpf){
        Cliente clienteExistente = clienteRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado com o CPF: " + cpf));
        return ClienteMapper.clienteToDTO(clienteExistente);
    }
    public <T> void VerificaCliente(Optional<T> entidadeOptional, String mensagemErro) {
        if (entidadeOptional.isPresent()) {
            throw new RuntimeException(mensagemErro);
        }
    }
}
