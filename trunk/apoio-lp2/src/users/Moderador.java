package users;

import java.util.List;

import controle.*;
import disciplina.Exercicio;

public class Moderador extends Usuario{
	private String turma = "";

	public Moderador(String nome, String login, String senha, String matricula, String email, String turma) throws Exception {
		super(nome, login, senha, matricula, email);
	}
	
	public void abrirTurma(String turma) {
		this.turma = turma;
	}
	public boolean cadastraAluno(String nome, String login, String senha, String matricula, String email, String turma) throws Exception{
		Aluno aluno = new Aluno(nome, login, senha, matricula, email, turma);
		BD.addAluno(aluno, turma);
		return true;
	}
	
	public String getTurma() {
		return this.turma;
	}
	
	public void verTutelados() {
		
	}

	public boolean setNotaAluno(Exercicio exercicio, Aluno aluno1) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public List<String> getTutelados(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<String> getMonitores() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<String> getAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean setNotaAluno(Submissao submissao, String loginAluno, Double nota) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String toString() {
		return "Matricula: " + getMatricula() + " | Nome: " + getNome();
	}

}
