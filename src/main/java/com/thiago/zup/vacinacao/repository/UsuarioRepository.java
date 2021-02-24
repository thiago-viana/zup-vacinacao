package com.thiago.zup.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.zup.vacinacao.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Usuario findByCpfOrEmail(String cpf, String email);
	
	Usuario findByCpf(String cpf);
}
