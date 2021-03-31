package com.biblioteca.locacaospringjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.locacaospringjpa.model.Locacao;
import com.biblioteca.locacaospringjpa.repository.LocacaoRepository;
import com.biblioteca.locacaospringjpa.service.LocacaoService;

@RestController
@RequestMapping (path = "/locacao")
public class LocacaoController {
	
	@Autowired
	private LocacaoRepository repository;
	
	private LocacaoService service;
	
	@Autowired
	public LocacaoController(LocacaoService service) {
		this.service = service;
	}
	
	@PostMapping
	public void post(@RequestBody Locacao locacao) {
		service.salvar(locacao);
	}
	
	@GetMapping
	public Iterable<Locacao> get() {
		return repository.findAll();
	}
	
	@GetMapping(path = "/find/{id}")
	public Locacao get(@PathVariable("id") Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
	
}
