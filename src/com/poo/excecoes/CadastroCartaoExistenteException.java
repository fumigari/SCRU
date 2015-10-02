package com.poo.excecoes;

public class CadastroCartaoExistenteException extends Exception{
	public CadastroCartaoExistenteException(){
		super("CARTÃO JÁ CADASTRADO");
	}
}
