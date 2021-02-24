package com.thiago.zup.vacinacao.controller.dto;

import com.thiago.zup.vacinacao.model.Usuario;

public class UsuarioDTO {
	
	private Long id;
	private String nome;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
