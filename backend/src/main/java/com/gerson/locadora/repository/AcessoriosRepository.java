package com.gerson.locadora.repository;

import com.gerson.locadora.entity.Acessorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcessoriosRepository extends JpaRepository<Acessorios,Long> {
    Optional<Acessorios> findByName(String name);

}
