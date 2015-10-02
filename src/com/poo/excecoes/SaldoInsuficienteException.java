package com.poo.excecoes;

public class SaldoInsuficienteException extends Exception{
	public SaldoInsuficienteException(){
		super("SEU SALDO É INSUFICIENTE");
	}
}
