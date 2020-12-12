package com.algaworks.algafood.domain.exception;

public class ColunaNulaNaoPermitidaEncontradaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ColunaNulaNaoPermitidaEncontradaException(String mensagem) {
		super(mensagem);
	}

}
