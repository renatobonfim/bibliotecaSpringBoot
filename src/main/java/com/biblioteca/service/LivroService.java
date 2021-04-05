package com.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repository;
	
	@Autowired
	public LivroService(LivroRepository repository) {
		this.repository = repository;
	}
	
	public void salvar(Livro livro) {
		
		
		if(livro.getTitulo() == null)
			throw new RuntimeException("Campo Titulo obrigatório!");
		
		if(livro.getIsbn() == null)
			throw new RuntimeException("Campo ISBN obrigatório!");
		
		if(livro.getExemplares() == 0 || livro.getExemplares() == null)
			throw new RuntimeException("Quantidade de Exemplares tem que ser maior que 0!");
		
		if(livro.getReservados() == null)
			throw new RuntimeException("Quantidade de Livros Reservados obrigatório!");
		
		if(livro.getValorDiaria() == 0 || livro.getValorDiaria() == null)
			throw new RuntimeException("Valor da Diaria tem que ser maior que 0!");
		
		
		for (Livro livrobd : repository.findAll()) {
			if(livrobd.equals(livro))
				throw new RuntimeException("Livro já cadastrado!");
		}
		
		
		repository.save(livro);
		
	}

}
