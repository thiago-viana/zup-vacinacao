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

import com.thiago.zup.vacinacao.controller.dto.UsuarioDTO;
import com.thiago.zup.vacinacao.controller.form.UsuarioForm;
import com.thiago.zup.vacinacao.model.Usuario;
import com.thiago.zup.vacinacao.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> cadastrar(@RequestBody @Valid UsuarioForm form, UriComponentsBuilder uriBuilder) {
		
		Usuario usuario = usuarioService.cadastrar(form);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
	}
}
