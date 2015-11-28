package com.poo.negocios.beans;

import java.io.Serializable;

public class ConsultarAluno implements Serializable{

	private Aluno aluno;

	public ConsultarAluno(Aluno aluno){
		this.setAluno(aluno);
		
	}
	
	public Aluno getAluno(){
		return this.aluno;
	}
	
	public void setAluno(Aluno aluno){
		this.aluno = aluno;
	}

	@Override
	public String toString() {
		return "Consultar Aluno\nAluno:" + this.getAluno();
	}

	
}
