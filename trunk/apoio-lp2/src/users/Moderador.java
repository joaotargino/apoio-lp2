package users;

import users.Aluno;
import disciplina.Turma;

public class Moderador extends Usuario{
	
	private Turma turma;
	private Aluno aluno;

	public Moderador(String nome, String login, String senha, String matricula, String email) {
		super(nome, login, senha, matricula, email);
		// TODO Auto-generated constructor stub
	}
	
	public boolean cadastraAluno(){
		if(turma.addAluno(aluno)){
			return true;
		}
		else return false;
	}
	
	

}
