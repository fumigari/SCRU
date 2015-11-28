package com.poo.negocios.beans;

import java.io.Serializable;

import com.poo.excecoes.CpfInvalidoException;
import com.poo.excecoes.StatusInvalidoException;

public class Aluno extends Pessoa implements Serializable{
	private int status;//1- Aluno Ativo || 2 - Aluno Desativado
	private boolean residente;
	
	//implementar foto
	public Aluno(String nome, String cpf, int status) throws CpfInvalidoException, StatusInvalidoException{
		super(nome, cpf);
		this.setStatus(status);
	}
	
	public int getStatus(){ 
		return this.status;
	}
	/**
	 * Verifica o estado do estudante
	 * 
	 * @param status define se o estudante é regular(1) ou desativado (0)	
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
	
	@Override
	public String toString(){
		return "Nome: " + this.getNome() + "\nCPF: " + this.getCpf() + "\nStatus: " + this.getStatus() + "\nResidente: " + this.getResidente();
	}
}
