package com.biblioteca.model;

import java.util.Date;

public class Sessao {
	
	private String login;
	
	private String token;

	private Date dataInicio;
	
	private Date dataFim;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return "Sessao {Token:" + token + ", Data da Expiração:" + dataFim + "}";
	}
	
	

	
}
