package com.biblioteca.locacaospringjpa.service;

import org.springframework.web.client.RestTemplate;

import com.biblioteca.locacaospringjpa.model.Endereco;

public class EnderecoService {
	
	public Endereco BuscaEndereco(String cep) {

		Endereco endereco = new Endereco();

		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
		
		endereco = restTemplate.getForObject(url, Endereco.class);
		
		return endereco;
		
	}
	
	
}
