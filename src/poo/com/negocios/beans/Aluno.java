package poo.com.negocios.beans;

import java.io.Serializable;

public class Aluno extends Pessoa implements Serializable{
	public Cartao cartao;
	public boolean residente;
	//implementar foto
	public Aluno(String nome, String cpf, Cartao cartao){
		super(nome, cpf);
		this.setCartao(cartao);
	}
	
	public void setCartao(Cartao cartao){
		if(!cartao.equals(null)){
			this.cartao = cartao;
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