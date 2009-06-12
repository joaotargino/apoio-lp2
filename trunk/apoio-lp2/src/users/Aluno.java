package users;

import controle.*;
import disciplina.*;
import disciplina.Exercicio;


public class Aluno extends Usuario{

	static final String NOVA_LINHA = System.getProperty("line.separator");
	
	public Aluno(String nome, String login, String senha, String matricula, String email, String turma) throws Exception {
		super(nome, login, senha, matricula, email);
	}
	
	public boolean submeterExercicio(Exercicio exercicio) {
		return Sistema.subemeterExercicio(getLogin(), exercicio);
			
	}
	
	@Override
	public String toString(){
			return "NOME: " +this.getNome() + NOVA_LINHA +
			"LOGIN: " + this.getLogin() + NOVA_LINHA +
			"EMAIL: " + this.getEmail();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Aluno) {
			Aluno aluno = (Aluno) obj;
			if (aluno.getLogin().equals(getLogin()))
				return true;
		}
		return false;
	}
}