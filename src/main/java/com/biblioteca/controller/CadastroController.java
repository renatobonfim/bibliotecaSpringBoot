package com.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Cadastro;
import com.biblioteca.repository.CadastroRepository;
import com.biblioteca.service.CadastroService;

@RestController
@RequestMapping (path = "/cadastro")
public class CadastroController {

	
	@Autowired
	private CadastroRepository repository;
	
	private CadastroService service;
	
	
	@Autowired
	public CadastroController(CadastroService service) {
		this.service = service;
	}
	
	
	@PostMapping
	public void post(@RequestBody Cadastro cadastro) {
		service.salvar(cadastro);
	}
	
	
	@GetMapping(path = "/buscar")
	public Iterable<Cadastro> get() {
		return repository.findAll();
	}
	
	@GetMapping(path = "/buscar/{id}")
	public Cadastro get(@PathVariable("id") Integer id) {
		return repository.findById(id).orElse(null);
	}
	
}
