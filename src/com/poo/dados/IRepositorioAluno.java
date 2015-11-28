package com.poo.dados;

import java.io.IOException;

import com.poo.excecoes.CadastroAlunoExistenteException;
import com.poo.negocios.beans.Aluno;

public interface IRepositorioAluno {

	boolean equals(Aluno a, Aluno B);
	public boolean existe(Aluno aluno);
	public void inserirAluno(Aluno aluno) throws IOException, CadastroAlunoExistenteException;
	public Aluno[] listarAlunos();
	
	

}
