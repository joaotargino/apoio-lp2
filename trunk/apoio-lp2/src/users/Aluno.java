//modificou
package users;

import java.util.Iterator;
import java.util.List;

import disciplina.Exercicios;
import disciplina.Turma;



public class Aluno extends Usuario{

	static final String NOVA_LINHA = System.getProperty("line.separator");
	private List<Exercicios> labsAluno;
	private String turma;
	
	public Aluno(String nome, String login, String senha, String matricula, String email, Turma turma) {
		super(nome, login, senha, matricula, email);
		this.turma = turma.getNome();
		
		// TODO Auto-generated constructor stub
	}
	
	public boolean submeterCodigo(){
		return true;
	}
	
	public void verCodigos(){
		Iterator iteraNotas = labsAluno.iterator();
		while (iteraNotas.hasNext()){
			System.out.print(iteraNotas.next()); //pensar a respeito!
		}
	}
	
	public void verNotas(){
		Iterator iteraNotas = labsAluno.iterator();
		while (iteraNotas.hasNext()){
			System.out.print(iteraNotas.next()); //.getNota q vai ser criado
		}
	}
	
	public String toString(){
		try {
			return "NOME: " +this.getNome() + NOVA_LINHA +
			"LOGIN: " + this.getLogin() + NOVA_LINHA +
			"EMAIL: " + this.getEmail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public String getTurma(){
		return this.turma;
	}

	public void listaExercicios(){
		//labsAlunos;
	}

}


//criar uma conexao aluno~lab