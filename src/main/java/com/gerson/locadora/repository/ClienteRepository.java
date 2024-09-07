package com.gerson.locadora.repository;

import com.gerson.locadora.dto.cliente.ClienteDTO;
import com.gerson.locadora.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByCpf(String cpf);
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByCnh(String cnh);
}
