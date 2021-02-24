package com.thiago.zup.vacinacao.controller.form;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.br.CPF;

import com.thiago.zup.vacinacao.model.AplicacaoVacina;
import com.thiago.zup.vacinacao.model.Usuario;
import com.thiago.zup.vacinacao.repository.UsuarioRepository;

public class AplicacaoVacinaForm {
	
	private static final String DATA_VALIDA = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
	
	@NotEmpty
	private String nomeVacina;
	
	@NotEmpty
	@CPF
	private String cpf;
	
	@NotEmpty
	@Pattern(regexp = DATA_VALIDA, message = "Deve está no formato dd/MM/yyyy")
	private String dataAplicacao;
	
	
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	
	public String getNomeVacina() {
		return nomeVacina;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getDataNascimento() {
		return dataAplicacao;
	}
	
	public void setDataAplicacao(String dataAplicacao) {
		this.dataAplicacao = dataAplicacao;
	}
	
	public AplicacaoVacina converter(UsuarioRepository usuarioRepository) {
		
		AplicacaoVacina aplicacaoVacina = new AplicacaoVacina();
		
		aplicacaoVacina.setNomeVacina(nomeVacina);
		
		Usuario usuario = usuarioRepository.findByCpf(cpf);
		aplicacaoVacina.setUsuario(usuario);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		aplicacaoVacina.setDataAplicacao(LocalDate.parse(dataAplicacao, formatter));
		
		return aplicacaoVacina;
	}
	
}