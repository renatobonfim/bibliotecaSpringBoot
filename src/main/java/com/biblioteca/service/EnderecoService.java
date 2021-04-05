package com.biblioteca.service;

import org.springframework.web.client.RestTemplate;

import com.biblioteca.model.Endereco;

public class EnderecoService {
	
	public Endereco BuscaEndereco(String cep) {

		Endereco endereco = new Endereco();

		RestTemplate restTemplate = new RestTemplate();
		
		String url = "https://viacep.com.br/ws/" + cep + "/json/";
				
		endereco = restTemplate.getForObject(url, Endereco.class);
		
		if(endereco.getCep() == null)
			throw new RuntimeException("CEP Não Encontrado!");
		
		return endereco;
		
	}
	
	
}
