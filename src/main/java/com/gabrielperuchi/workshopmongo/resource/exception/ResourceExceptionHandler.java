package com.gabrielperuchi.workshopmongo.resource.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gabrielperuchi.workshopmongo.services.exception.ObjetoNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjetoNaoEncontradoException.class) // Referencia este erro para disparar este método quando o erro acontecer
	public ResponseEntity<ErroPadrao> ObjetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND; // Erro 404

		ErroPadrao erro = new ErroPadrao();
		erro.setTimestamp(System.currentTimeMillis());
		erro.setStatus(status.value());
		erro.setErro("Não encontrado");
		erro.setMensagem(e.getMessage());
		erro.setCaminho(request.getRequestURI());

		return ResponseEntity.status(status).body(erro);
	}

}
