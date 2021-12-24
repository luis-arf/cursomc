package com.luisarf.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luisarf.cursomc.domain.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
