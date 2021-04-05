package com.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Cadastro;
import com.biblioteca.repository.CadastroRepository;

@Service
public class CadastroService {
	
	@Autowired
	private CadastroRepository repository;
	
	@Autowired
	public CadastroService(CadastroRepository repository) {
		this.repository = repository;
	}

	@Autowired
	private PasswordEncoder encoder;
	
	public void salvar(Cadastro cadastro) {
		
		
		if(cadastro.getNome() == null)
			throw new RuntimeException("Campo Nome obrigatório!");
		
		if(cadastro.getCpf() == null)
			throw new RuntimeException("Campo CPF obrigatório!");
		
		if(cadastro.getLogin() == null)
			throw new RuntimeException("Campo Login obrigatório!");
		
		if(cadastro.getSenha() == null)
			throw new RuntimeException("Campo Senha obrigatório!");
		
		if(cadastro.getEmail() == null)
			throw new RuntimeException("Campo E-mail obrigatório!");
		
		if(cadastro.getEndereco().getCep() == null)
			throw new RuntimeException("Campo CEP obrigatório!");
		
		String senhaencode = encoder.encode(cadastro.getSenha());
		
		cadastro.setSenha(senhaencode);
		
		EnderecoService endService = new EnderecoService();
		
		cadastro.setEndereco(endService.BuscaEndereco(cadastro.getEndereco().getCep()));
				
		
		for(Cadastro cadastrobd : repository.findAll()) {
			if (cadastrobd.equals(cadastro))
				throw new RuntimeException("Cliente já cadastrado!");
		}		
		
		repository.save(cadastro);
			
	}

}