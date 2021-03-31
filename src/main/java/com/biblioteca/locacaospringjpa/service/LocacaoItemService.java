package com.biblioteca.locacaospringjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.locacaospringjpa.model.Locacao;
import com.biblioteca.locacaospringjpa.model.LocacaoItem;
import com.biblioteca.locacaospringjpa.repository.LocacaoItemRepository;
import com.biblioteca.locacaospringjpa.repository.LocacaoRepository;

@Service
public class LocacaoItemService {
	
	@Autowired
	private LocacaoItemRepository repository;
	
	@Autowired
	public LocacaoItemService(LocacaoItemRepository repository) {
		this.repository = repository;
	}
	
	public void salvar(LocacaoItem locacaoItem) {
		//validacao
		repository.save(locacaoItem);
		
	}

}
