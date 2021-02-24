package com.thiago.zup.vacinacao.controller.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import com.thiago.zup.vacinacao.model.Usuario;

public class UsuarioForm {
	
	private static final String DATA_VALIDA = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	@NotEmpty
	@Pattern(regexp = DATA_VALIDA, message = "Deve está no formato dd/MM/yyyy")
	private String dataNascimento;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Usuario converter() {
		
		Usuario usuario = new Usuario();
		usuario.setNome(nome);
		usuario.setEmail(email);
		usuario.setCpf(cpf);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		usuario.setDataNascimento(LocalDate.parse(dataNascimento, formatter));
		
		return usuario;
	}
	
}