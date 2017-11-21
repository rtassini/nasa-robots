package com.nasa.robots.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Instrução inválida")
public class InstrucaoInvalidaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4704382359917248374L;

}
