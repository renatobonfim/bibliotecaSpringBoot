package com.biblioteca.locacaospringjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.locacaospringjpa.model.Livro;
import com.biblioteca.locacaospringjpa.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	public LivroService(LivroRepository repository) {
		this.repository = repository;
	}
	
	public void salvar(Livro livro) {
		//validacao
		repository.save(livro);
		
	}

}
