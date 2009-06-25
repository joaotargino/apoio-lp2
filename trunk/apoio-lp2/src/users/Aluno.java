package users;

import controle.*;
import disciplina.*;



public class Aluno extends Usuario {

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

}