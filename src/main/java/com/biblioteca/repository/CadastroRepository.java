package com.biblioteca.repository;

import org.springframework.data.repository.CrudRepository;

import com.biblioteca.model.Cadastro;

public interface CadastroRepository extends CrudRepository<Cadastro, Integer> {
	
	 Cadastro findByLogin(String login);
	 
}
