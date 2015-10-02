package com.poo.excecoes;

public class CartaoInvalidoException extends Exception{
	public CartaoInvalidoException(){
		super("CARTAO PESQUISADO INVALIDO");
	}
}
