package com.prueba.exception;

public class ExceptionMessage extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExceptionMessage(String mensaje) {
		super(mensaje);
	}

}
