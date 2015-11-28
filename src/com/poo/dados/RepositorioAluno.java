package com.poo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.poo.excecoes.AlunoInexistenteException;
import com.poo.excecoes.CadastroAlunoExistenteException;
import com.poo.negocios.beans.Aluno;

public class RepositorioAluno implements IRepositorioAluno, Serializable{
	private ArrayList<Aluno> listaDeAlunos;
	
	private static RepositorioAluno instance;
	
	public RepositorioAluno(){
		this.listaDeAlunos = new ArrayList<Aluno>();
	}
	
	public static IRepositorioAluno getInstance() throws IOException {
		if (instance == null) {
			instance = abrirArquivo();
		}
		return instance;
	}
	
	private static RepositorioAluno abrirArquivo() throws IOException {

		RepositorioAluno instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO ALUNOS\\cadastroalunos.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioAluno) o;
		} catch (Exception e) {
			
			instanciaLocal = new RepositorioAluno();
			
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

		File dir = new File("ARQUIVOS\\CADASTRO ALUNOS");
		dir.mkdirs();
		File out = new File(dir,"cadastroalunos.bin");
        
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
	 * @param aluno 
	 * @return Verdadeiro se for estudante e falso se não for estudante
	 */
	public boolean existe(Aluno aluno){
		boolean achou = false;
		for(int i = 0; i<this.listaDeAlunos.size();i++){
			if(this.listaDeAlunos.get(i).getCpf().equals(aluno.getCpf())){
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
	public void inserirAluno(Aluno aluno) throws IOException, CadastroAlunoExistenteException{
		if(!this.existe(aluno)){
			this.listaDeAlunos.add(aluno);
			salvarArquivo();
		}else{
			throw new CadastroAlunoExistenteException();
		}
	}
	
	public ArrayList<Aluno> listarAlunos(){
		return this.listaDeAlunos;
	}
	
	

	@Override
	public boolean equals(Aluno a, Aluno B) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
