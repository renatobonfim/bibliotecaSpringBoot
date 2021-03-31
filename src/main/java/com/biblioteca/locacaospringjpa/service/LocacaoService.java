package com.biblioteca.locacaospringjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.locacaospringjpa.model.Locacao;
import com.biblioteca.locacaospringjpa.repository.LocacaoRepository;

@Service
public class LocacaoService {
	
	@Autowired
	private LocacaoRepository repository;
	
	@Autowired
	public LocacaoService(LocacaoRepository repository) {
		this.repository = repository;
	}
	
	public void salvar(Locacao locacao) {
		//validacao
		repository.save(locacao);
		
	}

}
