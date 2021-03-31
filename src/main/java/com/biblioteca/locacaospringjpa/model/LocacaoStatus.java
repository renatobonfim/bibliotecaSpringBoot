package com.biblioteca.locacaospringjpa.model;

public enum LocacaoStatus {
	
	RESERVADA(1),
	EFETIVADA(2),
	FINALIZADA(3);
	 
	
	private int status;
	
	private LocacaoStatus(int status) {
		this.status = status;
	}
	
	private int getLocacaoStatus() {
		return this.status;
	}
}
