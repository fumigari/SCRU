package com.poo.excecoes;

public class StatusInvalidoException extends Exception{
	public StatusInvalidoException(){
		super("STATUS INVALIDO, FAVOR SELECIONAR UM STATUS VÁLIDO");
	}
}
