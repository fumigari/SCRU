package com.poo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.poo.excecoes.AlunoInexistenteException;
import com.poo.excecoes.CadastroAlunoExistenteException;
import com.poo.excecoes.ProcuraAlunoInexistenteException;
import com.poo.negocios.beans.Aluno;


public class RepositorioAluno implements IRepositorioAluno, Serializable{
	private Aluno[] listaDeAlunos;
	private int proxima;
	
	private static RepositorioAluno instance;
	
	public RepositorioAluno(int tamanho){
		this.listaDeAlunos = new Aluno[tamanho];
		this.proxima = 0;
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
			
			instanciaLocal = new RepositorioAluno(50);
			
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
		for(int i = 0; i <= (this.listaDeAlunos.length-1);i++){
			if(this.listaDeAlunos[i].getCpf().equals(aluno.getCpf())){
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
			this.listaDeAlunos[this.proxima] = aluno;
			this.proxima++;
			salvarArquivo();
		}else{
			throw new CadastroAlunoExistenteException();
		}
	}
	
	public Aluno[] listarAlunos(){
		return this.listaDeAlunos;
	}
	
	private void duplicaArrayAluno() {

		if (this.listaDeAlunos != null && this.listaDeAlunos.length > 0) {
		    Aluno[] arrayDuplicado = new Aluno[this.listaDeAlunos.length * 2];
			for (int i = 0; i < this.listaDeAlunos.length; i++) {
				arrayDuplicado[i] = this.listaDeAlunos[i];

			}
			this.listaDeAlunos = arrayDuplicado;
		}
	}
	
	/*public Aluno procurar(int numeroDoSini)throws ProcuraAlunoInexistenteException {
		int i = this.procurarIndice(numeroDoSini);
		Aluno resultado = null;
		if (i != this.proxima)
			resultado = this.sini[i];
		else
			throw new ProcuraAlunoInexistenteException();

		return resultado;
	} */
	

	@Override
	public boolean equals(Aluno a, Aluno B) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
