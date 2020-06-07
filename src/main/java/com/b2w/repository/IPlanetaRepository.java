package com.b2w.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.b2w.entity.Planeta;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPlanetaRepository extends JpaRepository<Planeta, Long> {

    @Query("SELECT p FROM Planeta p WHERE LOWER(p.nome) LIKE :palavraChave OR LOWER(p.clima) LIKE :palavraChave OR LOWER(p.terreno) LIKE :palavraChave")
    List<Planeta> buscarPorPalavraChave(@Param("palavraChave") String palavraChave);
}
