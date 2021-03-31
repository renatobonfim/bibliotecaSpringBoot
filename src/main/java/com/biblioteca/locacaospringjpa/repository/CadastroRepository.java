package com.biblioteca.locacaospringjpa.repository;

import org.springframework.data.repository.CrudRepository;

import com.biblioteca.locacaospringjpa.model.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, Integer> {
	
}
