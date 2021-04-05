package com.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.biblioteca.model.Locacao;

public interface LocacaoRepository extends CrudRepository<Locacao, Integer>{
	
}
