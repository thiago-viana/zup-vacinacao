package com.thiago.zup.vacinacao.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.thiago.zup.vacinacao.controller.dto.AplicacaoVacinaDTO;
import com.thiago.zup.vacinacao.controller.form.AplicacaoVacinaForm;
import com.thiago.zup.vacinacao.model.AplicacaoVacina;
import com.thiago.zup.vacinacao.repository.AplicacaoVacinaRepository;
import com.thiago.zup.vacinacao.repository.UsuarioRepository;

@RestController
@RequestMapping("/aplicacoes")
public class AplicacaoVacinaController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AplicacaoVacinaRepository aplicacaoVacinaRepository;
	
	@PostMapping
	public ResponseEntity<AplicacaoVacinaDTO> cadastrar(@RequestBody @Valid AplicacaoVacinaForm form,
			UriComponentsBuilder uriBuilder) {

		AplicacaoVacina aplicacaoVacina = form.converter(usuarioRepository);
		aplicacaoVacinaRepository.save(aplicacaoVacina);
		URI uri = uriBuilder.path("/aplicacoes/{id}").buildAndExpand(aplicacaoVacina.getId()).toUri();
		return ResponseEntity.created(uri).body(new AplicacaoVacinaDTO(aplicacaoVacina));
	}
}
