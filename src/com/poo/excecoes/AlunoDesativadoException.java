package com.poo.excecoes;

public class AlunoDesativadoException extends Exception{
	public AlunoDesativadoException(){
		super("ALUNO DESATIVADO.\nFAVOR PROCURAR O ADMINISTRADOR DO SISTEMA");
	}
}
