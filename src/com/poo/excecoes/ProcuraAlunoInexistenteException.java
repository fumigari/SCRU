package com.poo.excecoes;

public class ProcuraAlunoInexistenteException extends Exception{
	public ProcuraAlunoInexistenteException(){
		super("ALUNO PESQUISADO NÃO EXISTE.");
	}
}
