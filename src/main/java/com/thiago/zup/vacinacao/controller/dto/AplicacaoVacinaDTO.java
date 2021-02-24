package com.thiago.zup.vacinacao.controller.dto;

import java.time.format.DateTimeFormatter;

import com.thiago.zup.vacinacao.model.AplicacaoVacina;

public class AplicacaoVacinaDTO {
	
	private String nomeUsuario;
	private String nomeVacina;
	private String dataVacinacao;
	
	public AplicacaoVacinaDTO(AplicacaoVacina aplicacaoVacina) {
		this.nomeUsuario = aplicacaoVacina.getUsuario().getNome();
		this.nomeVacina = aplicacaoVacina.getNomeVacina();
		this.dataVacinacao = aplicacaoVacina.getDataAplicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public String getNomeVacina() {
		return nomeVacina;
	}
	public String getDataVacinacao() {
		return dataVacinacao;
	}
	
}
