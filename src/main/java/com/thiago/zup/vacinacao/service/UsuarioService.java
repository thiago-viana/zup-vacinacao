package com.thiago.zup.vacinacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiago.zup.vacinacao.controller.form.UsuarioForm;
import com.thiago.zup.vacinacao.exception.UsuarioExistenteException;
import com.thiago.zup.vacinacao.model.Usuario;
import com.thiago.zup.vacinacao.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario cadastrar(UsuarioForm form) {
		
		Usuario usuario = form.converter();
		
		Usuario usuarioExistente = usuarioRepository
				.findByCpfOrEmail(usuario.getCpf(), usuario.getEmail());
		
		if (usuarioExistente != null) {
			
			if (usuarioExistente.getCpf().equals(usuario.getCpf())) {				
				throw new UsuarioExistenteException("CPF", "já existe usuário(a) com o CPF " + usuario.getCpf());
			}
			
			if (usuarioExistente.getEmail().equals(usuario.getEmail())) {				
				throw new UsuarioExistenteException("EMAIL", "já existe usuário(a) com o Email " + usuario.getEmail());
			}
		}
		
		usuarioRepository.save(usuario);
		
		return usuario;
	}
}
