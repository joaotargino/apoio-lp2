package users;

import java.util.List;

public class Professor extends Moderador{
	public Professor(String nome, String login, String senha, String matricula, String email, String turma) throws Exception {
		super(nome, login, senha, matricula, email, turma);
		// TODO Auto-generated constructor stub
	}
	
	public boolean alocaAluno(String string, String string2) {
		return false;
	}
	
//	public boolean cadastraMonitor(Moderador monitor) {
//		return false;
//	}
	
	public boolean deletaMonitor(String string) {
		return false;
	}
	
	public boolean deletaAluno(Aluno aluno) {
		return false;
	}

	public boolean cadastraMonitor(String string, String string2, String string3,
			String string4, String string5, String turma) {
		return false;
		// TODO Auto-generated method stub
		
	}






}
