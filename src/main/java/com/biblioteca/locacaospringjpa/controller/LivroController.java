package com.biblioteca.locacaospringjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.locacaospringjpa.model.Livro;
import com.biblioteca.locacaospringjpa.repository.LivroRepository;
import com.biblioteca.locacaospringjpa.service.LivroService;

@RestController
@RequestMapping (path = "/livro")
public class LivroController {
	
	@Autowired
	private LivroRepository repository;
	
	private LivroService service;
	
	@Autowired
	public LivroController(LivroService service) {
		this.service = service;
	}
	
	@PostMapping
	public void post(@RequestBody Livro livro) {
		service.salvar(livro);
	}
	
	@GetMapping
	public Iterable<Livro> get() {
		return repository.findAll();
	}
	
	@GetMapping(path = "/find/{id}")
	public Livro get(@PathVariable("id") Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
}
