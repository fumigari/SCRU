package com.poo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.poo.excecoes.CadastroCartaoExistenteException;
import com.poo.negocios.beans.Cartao;

public class RepositorioCartao implements IRepositorioCartao, Serializable{
	private Cartao[] listaDeCartao;
	private int proxima;
	
	private static RepositorioCartao instance;
	
	public RepositorioCartao(int tamanho){
		this.listaDeCartao = new Cartao[tamanho];
		this.proxima = 0;
	}
	
	public static IRepositorioCartao getInstance() throws IOException {
		if (instance == null) {
			instance = abrirArquivo();
		}
		return instance;
	}
	
	private static RepositorioCartao abrirArquivo() throws IOException {

		RepositorioCartao instanciaLocal = null;
		File in = new File("DADOS\\CADASTRO CARTAO\\cadastrocartao.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioCartao) o;
		} catch (Exception e) {
			
			instanciaLocal = new RepositorioCartao(50);
			
		} finally {

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;

	}
	
	public static void salvarArquivo() throws IOException {

		if (instance == null) {
			return;
		}

		File dir = new File("DADOS\\CADASTRO CARTAO");
		dir.mkdirs();
		File out = new File(dir,"cadastrocartao.bin");
        
		if (!out.exists()){
			
			out.createNewFile();
        }
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);

		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {/* Silent */
				}
			}
		}
	}
	
	/**
	 * Verifica se um aluno é realmente da faculdade ou não
	 * 
	 * @param cartao 
	 * @return Verdadeiro se for estudante e falso se não for estudante
	 */
	public boolean existe(Cartao cartao){
		boolean achou = false;
		for(int i = 0; i <= (this.listaDeCartao.length-1); i++){
			if(this.listaDeCartao[i].getNumero().equals(cartao.getNumero())){
				achou = true;
			}
		}
		return achou;
	}
	
	/**
	 * Adiciona um novo aluno a lista de alunos
	 * 
	 * @param aluno
	 * @throws IOException
	 * @throws CadastroAlunoExistenteException
	 */
	public void inserirCartao(Cartao cartao) throws IOException, CadastroCartaoExistenteException{
		if(!this.existe(cartao)){
			this.listaDeCartao[this.proxima] = cartao;
			this.proxima++;
			salvarArquivo();
		}else{
			throw new CadastroCartaoExistenteException();
		}
	}
	
	public Cartao[] listarCartoes(){
		return this.listaDeCartao;
	}
	
	

	@Override
	public boolean equals(Cartao a, Cartao B) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}

