package poo.com.negocios.beans;

import java.io.Serializable;


public class Cartao implements Serializable{
	public int numero;
	public String validade;
	public String emissao;
	public int via;
	public double saldo;

	public Cartao(int numero, String validade, String emissao, int via, double saldo){
		this.setEmissao(emissao);
		this.setNumero(numero);
		this.setValidade(validade);
		this.setVia(via);
		this.setSaldo(saldo);
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
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

	@Override
	public String toString(){
		return "Numero do cartão: "+this.getNumero()+"\nValidade: "+this.getValidade()+"\nEmissao: "+this.getEmissao()+"\nVia: "+this.getVia()+"\nSaldo: "+this.getSaldo();
	}
}
