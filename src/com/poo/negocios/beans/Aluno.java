package com.poo.negocios.beans;

import java.io.Serializable;
import java.text.DecimalFormat;

import com.poo.excecoes.CpfInvalidoException;
import com.poo.excecoes.StatusInvalidoException;

public class Aluno extends Pessoa implements Serializable{
	private int status;//1- Aluno Ativo || 2 - Aluno Desativado
	private String curso;
	DecimalFormat df = new DecimalFormat("0.0");
	private float anoIngresso;
	private boolean residente;
	
	
	//implementar foto
	public Aluno(String nome, String cpf, int status, String curso, float anoIngresso) throws CpfInvalidoException, StatusInvalidoException{
		super(nome, cpf);
		this.setStatus(status);
		this.setCurso(curso);
		this.setAnoIngresso(anoIngresso);
	}
	
	public int getStatus(){ 
		return this.status;
	}
	/**
	 * Verifica o estado do estudante
	 * 
	 * @param status define se o estudante � regular(1) ou desativado (0)	
	 * 
	 */
	public void setStatus(int status) throws StatusInvalidoException{
		if(status == 0 || status == 1){
			this.status = status;
		}else{
			throw new StatusInvalidoException();
		}
	}
	
	
	public boolean getResidente(){
		return this.residente;
	}
	 
	public void setResidente(boolean residente){
		if(residente == true){
			
		}else{
			
		}
	}
	
	public String getCurso(){
		return this.curso;
	}
	
	public void setCurso(String curso){
		if(!curso.equals(null)){
			this.curso = curso;
		}
	}
	
	public float getAnoIngresso(){
		return this.anoIngresso;
	}
	
	public void setAnoIngresso(float anoIngresso){
		if(anoIngresso > 0){
			this.anoIngresso = anoIngresso;
		}
	}

	@Override
	public String toString() {
		return "Aluno\nNome: " + this.getNome()+ "\nCPF: " + this.getCpf() + 
				"\nStatus: " + this.getStatus() + "\nCurso: " + this.getCurso() + "\nAno de Ingresso: " + this.getAnoIngresso() + "\nResidente: "
				+ this.getResidente()+ "";
	}

}
