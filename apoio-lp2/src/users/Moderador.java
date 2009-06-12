package users;

import controle.*;

public class Moderador extends Usuario{
	private String turma = "";

	public Moderador(String nome, String login, String senha, String matricula, String email) throws Exception {
		super(nome, login, senha, matricula, email);
	}
	
	public void abrirTurma(String turma) {
		this.turma = turma;
	}
	public boolean cadastraAluno(String nome, String login, String senha, String matricula, String email) throws Exception{
		Aluno aluno = new Aluno(nome, login, senha, matricula, email);
		BD.addAluno(aluno, turma);
		return false;
		
	}
	
	public String getTurma() {
		return this.turma;
	}
	
	public void verTutelados() {
		
	}

	public boolean setNotaAluno(Submissao submissao, String loginAluno, Double nota) {
		// TODO Auto-generated method stub
		return false;
	}

}
