package com.biblioteca.locacaospringjpa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Embeddable
//@EnableAutoConfiguration
//@Table(name="tb_endereco")
public class Endereco {
	
	@Column(length=9, nullable=false)
	private String cep;
	
	@Column(length=255)
	private String logradouro;
	
	@Column(length=255)
	private String bairro;
	
	@Column(length=255)
	private String localidade;
	
	@Column(length=50)
	private String uf;
	
	@Column(length=22)
	private Integer ibge;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getIbge() {
		return ibge;
	}

	public void setIbge(Integer ibge) {
		this.ibge = ibge;
	}
	
	
}
