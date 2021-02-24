package com.thiago.zup.vacinacao.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AplicacaoVacina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeVacina;
	
	@ManyToOne
	private Usuario usuario;
	
	private LocalDate dataAplicacao;
	
	
	public Long getId() {
		return id;
	}
	
	public String getNomeVacina() {
		return nomeVacina;
	}
	
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public LocalDate getDataAplicacao() {
		return dataAplicacao;
	}
	
	public void setDataAplicacao(LocalDate dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}
	
}
