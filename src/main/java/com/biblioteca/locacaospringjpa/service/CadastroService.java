package com.biblioteca.locacaospringjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.locacaospringjpa.model.Cadastro;
import com.biblioteca.locacaospringjpa.repository.CadastroRepository;

@Service
public class CadastroService {
	
	@Autowired
	private CadastroRepository repository;
	
	@Autowired
	public CadastroService(CadastroRepository repository) {
		this.repository = repository;
	}
	
	public void salvar(Cadastro cad) {
		
		EnderecoService endService = new EnderecoService();
		
		cad.setEndereco(endService.BuscaEndereco(cad.getEndereco().getCep()));
				
		repository.save(cad);
			
	}

}