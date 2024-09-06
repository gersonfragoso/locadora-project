package com.gerson.locadora.repository;

import com.gerson.locadora.entity.ApoliceSeguro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoliceRepository extends JpaRepository<ApoliceSeguro,Long> {
}
