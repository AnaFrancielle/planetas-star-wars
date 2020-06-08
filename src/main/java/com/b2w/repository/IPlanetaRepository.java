package com.b2w.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.b2w.entity.Planeta;

import java.util.List;
import java.util.Optional;

@Repository
public interface IPlanetaRepository extends MongoRepository<Planeta, Long> {

    Planeta findById(String id);
    List<Planeta> findByNomeLikeOrClimaLikeOrTerrenoLikeOrIdLike(String nome, String clima, String terreno, String id);

}
