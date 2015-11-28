package com.poo.dados;

import java.io.IOException;

import com.poo.excecoes.CadastroCartaoExistenteException;
import com.poo.negocios.beans.Cartao;

public interface IRepositorioCartao {

	boolean equals(Cartao a, Cartao B);
	public boolean existe(Cartao cartao);
	public void inserirCartao(Cartao cartao)throws IOException, CadastroCartaoExistenteException;
	public Cartao[] listarCartoes();
	
	
	

}
