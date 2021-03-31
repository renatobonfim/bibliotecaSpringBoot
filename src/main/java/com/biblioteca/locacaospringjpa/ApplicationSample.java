package com.biblioteca.locacaospringjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biblioteca.locacaospringjpa.model.Cadastro;
import com.biblioteca.locacaospringjpa.model.Endereco;
import com.biblioteca.locacaospringjpa.model.Livro;
import com.biblioteca.locacaospringjpa.model.Locacao;
import com.biblioteca.locacaospringjpa.model.LocacaoStatus;
import com.biblioteca.locacaospringjpa.repository.CadastroRepository;
import com.biblioteca.locacaospringjpa.repository.LivroRepository;
import com.biblioteca.locacaospringjpa.repository.LocacaoRepository;

@Component
public class ApplicationSample {
	
	@Autowired
	//private LocacaoRepository locacaoRepository;
	private CadastroRepository cadRepos;
	@Autowired
	private LivroRepository livroRepos;
	
	//public String buscaCEP()
	
	
	
	/*public Cadastro cadastrarCadastro() {
		Cadastro cadCadastro = new Cadastro();
		cadCadastro.setNome("Rodrigo Martins");
		cadCadastro.setCpf("111.111.111-11");
		Endereco endereco = new Endereco();
		endereco.setCep("31742-527");
		
		cadCadastro.setEndereco(endereco);
		
		if(cadCadastro.equals(cadCadastro))
			return cadRepos.save(cadCadastro);
		else
			return cadCadastro = new Cadastro();
	}
	
	
	public Livro cadLivro() {
		Livro cadLivro = new Livro();
		cadLivro.setIsbn("34243GFGA");
		cadLivro.setTitulo("Titulo 1");
		cadLivro.setReservados(0);
		cadLivro.setExemplares(5);
		cadLivro.setValorDiaria(15.99);
		
		return livroRepos.save(cadLivro);
		
	}*/
	
	
	
	
	
	
	/*public Locacao cadlocacao() {
		
		Locacao locacao = new Locacao();
		locacao.setValorTotal(41.22);
		locacao.setLocacaoStatus(LocacaoStatus.EFETIVADA));
		locacao.setCadastro()
		
		
		return locacaoRepository.save(locacao);
		
	}*/
}
