package com.thiago.zup.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thiago.zup.vacinacao.model.AplicacaoVacina;

public interface AplicacaoVacinaRepository extends JpaRepository<AplicacaoVacina, Long> {

}
