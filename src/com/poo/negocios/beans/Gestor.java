package com.poo.negocios.beans;

import com.poo.excecoes.CpfInvalidoException;

public class Gestor extends Pessoa{
	private int permissao;
	private Cartao cartaoGestor;

	public Gestor(String nome, String cpf, int permissao, Cartao cartaoGestor) throws CpfInvalidoException{
		super(nome, cpf);
		this.setPermissao(permissao);
		this.setCartaoGestor(cartaoGestor);
	}

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		if(permissao >= 1){
			this.permissao = permissao;
		}
	}

	public Cartao getCartaoGestor() {
		return cartaoGestor;
	}

	public void setCartaoGestor(Cartao cartaoGestor) {
		if(!cartaoGestor.equals(null)){
			this.cartaoGestor = cartaoGestor;
		}
	}




}
