package com.nasa.robots.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Veículo movido para fora do terreno")
public class ForaTerrenoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -619778038763046655L;

	
	
}
