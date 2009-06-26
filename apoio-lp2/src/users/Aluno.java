package users;

import controle.*;
import disciplina.*;

public class Aluno extends Usuario {

	

	public Aluno(String nome, String login, String senha, String matricula,
			String email, String turma) throws Exception {
		super(nome, login, senha, matricula, email, turma);
	}
	
	public UsuariosEnum getEnum() {
		return UsuariosEnum.ALUNO;
	}

}