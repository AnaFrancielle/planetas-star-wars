package com.b2w.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b2w.entity.Planeta;

@Repository 
public interface IPlanetaRepository extends JpaRepository<Planeta, Long>{

}
