package com.poo.negocios.beans;

import java.io.Serializable;

import com.poo.excecoes.CpfInvalidoException;
import com.poo.excecoes.StatusInvalidoException;

public class Aluno extends Pessoa implements Serializable{
	private Cartao cartao;
	private int status;//1- Aluno Ativo || 2 - Aluno Desativado
	private boolean residente;
	
	//implementar foto
	public Aluno(String nome, String cpf, Cartao cartao, int status) throws CpfInvalidoException, StatusInvalidoException{
		super(nome, cpf);
		this.setCartao(cartao);
		this.setStatus(status);
	}
	
	
	
	public void setStatus(int status) throws StatusInvalidoException{
		if(status == 0 || status == 1){
			this.status = status;
		}else{
			throw new StatusInvalidoException();
		}
	}
	
	public void setCartao(Cartao cartao){
		if(!cartao.equals(null)){
			this.cartao = cartao;
			cartao.setNumero(this.getCpf());
		}
	}
	
	public Cartao getCartao(){
		return this.cartao;
	}
	
	@Override
	public String toString(){
		return "Nome: "+this.getNome()+"CPF: "+this.getCpf();
	}
}
