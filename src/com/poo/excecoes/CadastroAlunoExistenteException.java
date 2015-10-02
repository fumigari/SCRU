package com.poo.excecoes;

public class CadastroAlunoExistenteException extends Exception{
	public CadastroAlunoExistenteException(){
		super("ALUNO JA EXISTE NO SISTEMA");
	}
}
