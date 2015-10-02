package com.poo.excecoes;

public class CadastroGestorExistenteException extends Exception{
	public CadastroGestorExistenteException(){
		super("GESTOR JÁ CADASTRADO NO SISTEMA");
	}
}
