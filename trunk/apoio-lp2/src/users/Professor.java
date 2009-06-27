package users;

import controle.UsuariosEnum;

/**
 * Classe que cria um usuario do tipo professor
 * @author Joao Paulo
 * @author Jessica Priscila
 * @author Erickson Filipe
 * @author Arnett Rufino
 *
 */

public class Professor extends Moderador{
	public Professor(int id, String nome, String login, String senha, String matricula, String email, String turma) throws Exception {
		super(id, nome, login, senha, matricula, email, turma);
	}

	@Override
	public UsuariosEnum getEnum() {
		return UsuariosEnum.PROFESSOR;
	}
}
