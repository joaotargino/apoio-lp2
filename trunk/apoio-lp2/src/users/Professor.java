package users;

import controle.UsuariosEnum;

public class Professor extends Moderador{
	public Professor(String nome, String login, String senha, String matricula, String email, String turma) throws Exception {
		super(nome, login, senha, matricula, email, turma);
	}

	public UsuariosEnum getEnum() {
		return UsuariosEnum.PROFESSOR;
	}
}
