package com.poo.excecoes;

public class CartaoInvalidoException extends Exception{
	public CartaoInvalidoException(){
		super("CARTÃO PESQUISADO INVALIDO");
	}
}
