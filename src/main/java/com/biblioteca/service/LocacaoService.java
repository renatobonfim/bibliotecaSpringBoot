package com.biblioteca.service;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.model.Livro;
import com.biblioteca.model.Locacao;
import com.biblioteca.model.LocacaoItem;
import com.biblioteca.model.LocacaoStatus;
import com.biblioteca.repository.CadastroRepository;
import com.biblioteca.repository.LivroRepository;
import com.biblioteca.repository.LocacaoRepository;

@Service
public class LocacaoService {
	
	@Autowired
	private LocacaoRepository repository;
	
	@Autowired
	private CadastroRepository cadastrorepository;
	
	@Autowired
	private LivroRepository livrorepository;
	
	@Autowired
	public LocacaoService(LocacaoRepository repository, LivroRepository livrorepository, CadastroRepository cadastrorepository) {
		this.repository = repository;
		this.livrorepository = livrorepository;
		this.cadastrorepository = cadastrorepository;
	}
	
	
	private ArrayList<Livro> livrosreservados;
	
	private ArrayList<Locacao> locacoes;
	
	public void agendarLocacao(Locacao locacao) {
		
		livrosreservados = new ArrayList<Livro>();
		
		if(locacao.getLocacaoStatus().getLocacaoStatus() != 0)
			throw new RuntimeException("Opção Incorreta!");
		
		locacao.setDataAgendamento(new Date());
		
		locacao.setLocacaoStatus(LocacaoStatus.RESERVADA);
		
		if(cadastrorepository.findById(locacao.getCadastro().getId()).isEmpty())
			throw new RuntimeException("Cadastro não encontrado!");
		
		for(Livro livro : livrorepository.findAll()) {
			for(LocacaoItem item : locacao.getItens()) {
				
				if(livrorepository.findById(item.getLivro().getId()).isEmpty()) {
					throw new RuntimeException("Livro não encontrado - Id:" + item.getLivro().getId());
				} else {
					item.setLivro(livrorepository.findById(item.getLivro().getId()).orElse(null));
					if(item.getLivro().getExemplares() >= 1) {
						livro.setReservados(livro.getReservados()+1);
						livro.setExemplares(livro.getExemplares()-1);
						livrosreservados.add(livro);
						
					} else
						throw new RuntimeException("Quantidade insuficiente para livro - Id: " + item.getLivro().getId());
						
				}
			}
		}
		
		
		for(Livro livro : livrosreservados)
			livrorepository.save(livro);
		
		
		repository.save(locacao);
		
	}
	
	
	public void finalizarLocacao(int id) {
		
		if(repository.findById(id).isEmpty()){
			throw new RuntimeException("Locação não encontrada - Id:" + id);
		}
		
		Locacao locacao = repository.findById(id).orElse(null);
		
		if(locacao.getLocacaoStatus().getLocacaoStatus() == 2)
			throw new RuntimeException("Locação já finalizada");
		
		livrosreservados = new ArrayList<Livro>();
		
		for(Livro livro : livrorepository.findAll()) {
			for(LocacaoItem item : locacao.getItens()) {
				if(item.getLivro().getId().equals(livro.getId())) {
					livro.setReservados(livro.getReservados() - 1);
					livro.setExemplares(livro.getExemplares() + 1);
					livrosreservados.add(livro);
					item.setDataEntrega(new Date());
				}
				
			}
		}
		
		locacao.setLocacaoStatus(LocacaoStatus.FINALIZADA);
		
		locacao.setDataFinalizacao(new Date());
		
		for(Livro livro : livrosreservados)
			livrorepository.save(livro);
		
		repository.save(locacao);
	}
	
	
	public void efetivarLocacao(int id) {
		if(repository.findById(id).isEmpty()){
			throw new RuntimeException("Locação não encontrada - Id:" + id);
		}
		
		Locacao locacao = repository.findById(id).orElse(null);
		
		if(locacao.getLocacaoStatus().getLocacaoStatus() != 0)
			throw new RuntimeException("Locação já efetivada ou finalizada");
		
		locacao.setLocacaoStatus(LocacaoStatus.EFETIVADA);
		
		locacao.setDataRetirada(new Date());
			
		repository.save(locacao);
		
		
	}
	
	
	public Iterable<Locacao> buscaLocacaoAll(){
		
		locacoes = new ArrayList<Locacao>();
		
		for(Locacao locacao : repository.findAll()) {
			for(LocacaoItem item : locacao.getItens()) {
				
				if(locacao.getLocacaoStatus().getLocacaoStatus() == 1 && item.getDataEntrega() == null) {
					
					int diarias = 0;
					
					long diffDays = (new Date().getTime() - locacao.getDataRetirada().getTime()) / (24 * 60 * 60 * 1000) + 1;
				    
					diarias = (int) diffDays;
					
					item.setDiarias(diarias);
					
					item.setValorLocacao(diarias * item.getLivro().getValorDiaria());
					
					locacao.setValorTotal(locacao.getValorTotal() + item.getValorLocacao());
					
					repository.save(locacao);
				    
				}
			}
			
			
		}
		
		
		
		
		return repository.findAll(); 
	}

	
	public ArrayList<Locacao> buscaLocacaoStatus(int status){
		
		locacoes = new ArrayList<Locacao>();
		
		for(Locacao locacao : repository.findAll()) {
			if(locacao.getLocacaoStatus().getLocacaoStatus() == status) {
				locacoes.add(locacao);
			}
			
		}
		
		return locacoes;
	}
	
	public ArrayList<Locacao> buscaLocacaoCadastro(int id){
		locacoes = new ArrayList<Locacao>();
		
		for(Locacao locacao : repository.findAll()) {
			if(locacao.getCadastro().getId() == id) {
				locacoes.add(locacao);
			}
			
		}
		
		return locacoes;
	}
	
	public ArrayList<Locacao> buscaLocacaoAgendada(Date data){
		locacoes = new ArrayList<Locacao>();
		
		for(Locacao locacao : repository.findAll()) {
			if(locacao.getDataRetirada() != null && locacao.getDataAgendamento().equals(data)) {
				locacoes.add(locacao);
			}
			
		}
		
		return locacoes;
	}
	
	public ArrayList<Locacao> buscaLocacaoRetirada(Date data){
		locacoes = new ArrayList<Locacao>();
		
		for(Locacao locacao : repository.findAll()) {
			if(locacao.getDataRetirada() != null  && locacao.getDataRetirada().equals(data)) {
				locacoes.add(locacao);
			}
			
		}
		
		return locacoes;
	}
	
}
