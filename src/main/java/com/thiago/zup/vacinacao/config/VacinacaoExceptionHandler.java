package com.thiago.zup.vacinacao.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.thiago.zup.vacinacao.controller.dto.ErroFormDto;
import com.thiago.zup.vacinacao.exception.UsuarioExistenteException;

@RestControllerAdvice
public class VacinacaoExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormDto> parametroInvalido(MethodArgumentNotValidException exception) {
		
		List<ErroFormDto> dto = new ArrayList<ErroFormDto>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		fieldErrors.forEach(fe -> {
			String mensagem = messageSource.getMessage(fe, LocaleContextHolder.getLocale());
			ErroFormDto erro = new ErroFormDto(fe.getField(), mensagem);
			dto.add(erro);
		});
		
		return dto;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UsuarioExistenteException.class)
	public ErroFormDto UsuarioExistente(UsuarioExistenteException exception) {
		return new ErroFormDto(exception.getCampo(), exception.getMensagem());
	}
	
}
