package com.poo.dados;

import java.io.IOException;

import com.poo.excecoes.CadastroGestorExistenteException;
import com.poo.negocios.beans.Gestor;

public interface IRepositorioGestor {

	boolean equals(Gestor a, Gestor B);
	public boolean existe(Gestor gestor);
	public void inserirGestor(Gestor gestor) throws IOException, CadastroGestorExistenteException;
	public Gestor[] listarGestores();
	

}
