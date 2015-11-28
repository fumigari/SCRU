package com.poo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


import com.poo.excecoes.CadastroGestorExistenteException;
import com.poo.negocios.beans.Gestor;

public class RepositorioGestor implements IRepositorioGestor, Serializable{
	private Gestor[] listaDeGestores;
	private int proxima; //primeira posição vazia do vetor de gestor
	private static RepositorioGestor instance;
	
	public RepositorioGestor(int tamanho){
		this.listaDeGestores = new Gestor[tamanho];
		this.proxima = 0;
	}
	
	public static IRepositorioGestor getInstance() throws IOException {
		if (instance == null) {
			instance = abrirArquivo();
		}
		return instance;
	}
	
	private static RepositorioGestor abrirArquivo() throws IOException {

		RepositorioGestor instanciaLocal = null;
		File in = new File("DADOS\\CADASTRO GESTORES\\cadastrogestores.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioGestor) o;
		} catch (Exception e) {
			
			instanciaLocal = new RepositorioGestor(50);
			
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

		File dir = new File("DADOS\\CADASTRO GESTORES");
		dir.mkdirs();
		File out = new File(dir,"cadastrogestores.bin");
        
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
	 * Faz uma busca para conferir se o Gestor é cadastrado ou não cadastrado
	 * 
	 * @param gestor  
	 * @return verdadeiro se já existe ou falso se é inexistente
	 */
	public boolean existe(Gestor gestor){
		boolean achou = false;
		for(int i = 0; i <= (this.listaDeGestores.length-1);i++){
			if(this.listaDeGestores[i].getCpf().equals(gestor.getCpf())){
				achou = true;
			}
		}
		return achou;
	}
	
	/**
	 * Adiciona um novo gestor a lista de gestores
	 * 
	 * @param gestores
	 * @throws IOException
	 * @throws CadastroGestorExistenteException
	 */
	public void inserirGestor(Gestor gestor) throws IOException, CadastroGestorExistenteException{
		if(!this.existe(gestor)){
			this.listaDeGestores[this.proxima] = gestor ;
			this.proxima++;
			salvarArquivo();
		}else{
			throw new CadastroGestorExistenteException();
		}
	}
	
	public Gestor[] listarGestores(){
		return this.listaDeGestores;
	}
	
	

	@Override
	public boolean equals(Gestor a, Gestor B) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}