package com.biblioteca.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Locacao;
import com.biblioteca.model.LocacaoStatus;
import com.biblioteca.repository.LocacaoRepository;
import com.biblioteca.service.LocacaoService;

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
	
	@PostMapping(path = "/agendar")
	public void agendarLocacao(@RequestBody Locacao locacao) {
		service.agendarLocacao(locacao);
	}
	
	@PostMapping(path = "/efetivar/{id}")
	public void efetivarLocacao(@PathVariable("id") Integer id) {
		service.efetivarLocacao(id);
	}
	
	
	@PostMapping(path = "/finalizar/{id}")
	public void finalizarLocacao(@PathVariable("id") Integer id) {
		service.finalizarLocacao(id);
	}
	
	
	@GetMapping(path = "/buscar")
	public Iterable<Locacao> get() {
		return service.buscaLocacaoAll();
	}
	
	@GetMapping(path = "/buscar/{id}")
	public Locacao get(@PathVariable("id") Integer id) {
		return repository.findById(id).orElse(null);
	}
	
	@GetMapping(path = "/buscarStatus/{status}")
	public Iterable<Locacao> ConsultaLocacaoStatus(@PathVariable("status") int locacaoStatus){
		
		ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
		
		locacoes = service.buscaLocacaoStatus(locacaoStatus);
		
		return locacoes;
		
	}
	
	@GetMapping(path = "/buscarCadastro/{id}")
	public ArrayList<Locacao> ConsultaLocacaoCadastro(@PathVariable("id") int id){
		ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
		
		locacoes = service.buscaLocacaoCadastro(id);
		
		return locacoes;

	}
	
	@GetMapping(path = "/buscarDataAgendada/{data}")
	public ArrayList<Locacao> ConsultaLocacaoAgendada(@PathVariable("data") String data) throws Exception{
		ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
		
		Date dataformat = new SimpleDateFormat("dd-MM-yyyy").parse(data);
		
		locacoes = service.buscaLocacaoAgendada(dataformat);
		
		return locacoes;

	} 
	
	@GetMapping(path = "/buscarDataRetirada/{data}")
	public ArrayList<Locacao> ConsultaLocacaoRetirada(@PathVariable("data") String data) throws Exception{
		ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
		
		Date dataformat = new SimpleDateFormat("dd-MM-yyyy").parse(data);
		
		locacoes = service.buscaLocacaoRetirada(dataformat);
		
		return locacoes;

	}  
	
	
}
