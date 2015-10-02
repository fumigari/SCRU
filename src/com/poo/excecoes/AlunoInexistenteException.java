package com.poo.excecoes;

public class AlunoInexistenteException extends Exception{
	public AlunoInexistenteException(){
		super("ALUNO PESQUISADO NÃO CADASTRADO");
	}
}
