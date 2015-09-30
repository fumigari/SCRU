package poo.com.negocios.beans;

public class Pessoa {
	private String nome;
	private String cpf;

	public Pessoa(String nome, String cpf){
		this.setCpf(cpf);
		this.setNome(nome);
	}

	public void setNome(String nome){
		if(!nome.equals(null)){
			this.nome = nome;
		}
	}
	
	public void setCpf(String cpf){
		if(!cpf.equals(null)){
			this.cpf = nome;
		}
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getCpf(){
		return this.cpf;
	}
	
}
