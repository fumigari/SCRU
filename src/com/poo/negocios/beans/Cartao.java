package com.poo.negocios.beans;

import java.io.Serializable;


public class Cartao implements Serializable{
	private String numero;
	private String validade;
	private String emissao;
	private int via;
	private double saldo;
	private Aluno aluno;

	public Cartao(String validade, String emissao, int via, double saldo, Aluno aluno){
		this.setEmissao(emissao);
		this.setValidade(validade);
		this.setVia(via);
		this.setSaldo(saldo);
		this.setAluno(aluno);
	}
	
	public void creditar(double valor){
		if(valor>0){
			this.saldo += valor;
		}
	}

	public double getSaldo(){
		return this.saldo;
	}

	public void setSaldo(double saldo){
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getEmissao() {
		return emissao;
	}

	public void setEmissao(String emissao) {
		this.emissao = emissao;
	}

	public int getVia() {
		return via;
	}

	public void setVia(int via) {
		this.via = via;
	}
	
	public Aluno getALuno(){
		return this.aluno;
	}
	
	public void setAluno(Aluno aluno){
		if(!aluno.equals(null)){
			this.aluno = aluno;
		}
	}

	@Override
	public String toString(){
		return "Numero do cartão: " + this.getNumero() + "\nValidade: " + this.getValidade() + "\nEmissao: " + this.getEmissao() + "\nVia: " + this.getVia() + "\nSaldo: " + this.getSaldo() + "\nAluno: " + this.aluno;
	}
}
