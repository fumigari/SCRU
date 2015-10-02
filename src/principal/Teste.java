package principal;

import java.io.IOException;

import com.poo.dados.RepositorioAluno;
import com.poo.excecoes.CadastroAlunoExistenteException;
import com.poo.excecoes.CpfInvalidoException;
import com.poo.excecoes.StatusInvalidoException;
import com.poo.negocios.beans.Aluno;
import com.poo.negocios.beans.Cartao;

public class Teste {

	public static void main(String[] args) throws CpfInvalidoException, StatusInvalidoException, IOException, CadastroAlunoExistenteException {
		// TODO Auto-generated method stub
	
	Cartao a1 = new Cartao("10/20/15", "01/11/11", 0, 1);
	Aluno a = new Aluno("Thiago", "09198875469", a1, 1);
	RepositorioAluno teste = new RepositorioAluno();
	teste.inserirAluno(a);
	
	teste.listarAlunos();
	
	
	
	}

}
