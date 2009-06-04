package users;

import java.util.Iterator;
import java.util.List;

import exercicios.Labs;

public class Aluno extends Usuario{

	private List<Labs> labsAluno;
	
	public Aluno(String login, String senha, String matricula, String email) {
		super(login, senha, matricula, email);
		
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



}


//criar uma conexao aluno~lab