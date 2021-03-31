package com.biblioteca.locacaospringjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.locacaospringjpa.model.LocacaoItem;
import com.biblioteca.locacaospringjpa.repository.LocacaoItemRepository;
import com.biblioteca.locacaospringjpa.service.LocacaoItemService;

@RestController
@RequestMapping (path = "/locacaoitem")
public class LocacaoItemController {
	
	@Autowired
	private LocacaoItemRepository repository;
	
	private LocacaoItemService service;
	
	@Autowired
	public LocacaoItemController(LocacaoItemService service) {
		this.service = service;
	}
	
	@PostMapping
	public void post(@RequestBody LocacaoItem locacaoItem) {
		service.salvar(locacaoItem);
	}
	
	@GetMapping
	public Iterable<LocacaoItem> get() {
		return repository.findAll();
	}
	
	@GetMapping(path = "/find/{id}")
	public LocacaoItem get(@PathVariable("id") Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	@DeleteMapping(path = "/delete/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}
	
	
}
