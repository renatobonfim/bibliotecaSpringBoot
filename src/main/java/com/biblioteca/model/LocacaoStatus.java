package com.biblioteca.model;

public enum LocacaoStatus {
	
	RESERVADA(0),
	EFETIVADA(1),
	FINALIZADA(2);
	 
	
	private int status;
	
	private LocacaoStatus(int status) {
		this.status = status;
	}
	
	public int getLocacaoStatus() {
		return this.status;
	}
}
