package com.gerson.locadora.repository;

import com.gerson.locadora.entity.Acessorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessoriosRepository extends JpaRepository<Acessorios,Long> {
}
