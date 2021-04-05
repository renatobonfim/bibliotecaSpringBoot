package com.biblioteca.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@EnableAutoConfiguration
@Table(name="tb_locacao")
public class Locacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date dataRetirada;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date dataAgendamento;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable=true)
	private Date dataFinalizacao;
	
	@Column(nullable=false)
	private double valorTotal;
	
	@Enumerated(EnumType.ORDINAL)
	private LocacaoStatus locacaoStatus;
	
	@ManyToOne
	@JoinColumn(name = "id_cadastro")
	private Cadastro cadastro;
	
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "locacao")
	private List<LocacaoItem> itens;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocacaoStatus getLocacaoStatus() {
		return locacaoStatus;
	}

	public void setLocacaoStatus(LocacaoStatus locacaoStatus) {
		this.locacaoStatus = locacaoStatus;
	}

	public Cadastro getCadastro() {
		return cadastro;
	}

	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	public Date getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Date dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public List<LocacaoItem> getItens() {
		return itens;
	}

	public void setItens(List<LocacaoItem> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cadastro == null) ? 0 : cadastro.hashCode());
		result = prime * result + ((dataAgendamento == null) ? 0 : dataAgendamento.hashCode());
		result = prime * result + ((dataFinalizacao == null) ? 0 : dataFinalizacao.hashCode());
		result = prime * result + ((dataRetirada == null) ? 0 : dataRetirada.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itens == null) ? 0 : itens.hashCode());
		result = prime * result + ((locacaoStatus == null) ? 0 : locacaoStatus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorTotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Locacao other = (Locacao) obj;
		if (cadastro == null) {
			if (other.cadastro != null)
				return false;
		} else if (!cadastro.equals(other.cadastro))
			return false;
		if (dataAgendamento == null) {
			if (other.dataAgendamento != null)
				return false;
		} else if (!dataAgendamento.equals(other.dataAgendamento))
			return false;
		if (dataFinalizacao == null) {
			if (other.dataFinalizacao != null)
				return false;
		} else if (!dataFinalizacao.equals(other.dataFinalizacao))
			return false;
		if (dataRetirada == null) {
			if (other.dataRetirada != null)
				return false;
		} else if (!dataRetirada.equals(other.dataRetirada))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itens == null) {
			if (other.itens != null)
				return false;
		} else if (!itens.equals(other.itens))
			return false;
		if (locacaoStatus != other.locacaoStatus)
			return false;
		if (Double.doubleToLongBits(valorTotal) != Double.doubleToLongBits(other.valorTotal))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
