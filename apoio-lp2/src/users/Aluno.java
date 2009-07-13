package users;

import controle.*;


/**
 * Classe que cria um usuario do tipo aluno
 * @author Joao Paulo
 * @author Jessica Priscila
 * @author Erickson Filipe
 * @author Arnett Rufino
 *
 */
public class Aluno extends Usuario {

	

	public Aluno(String nome, String login, String senha, String matricula,
			String email, String turma) throws Exception {
		super(nome, login, senha, matricula, email, turma);
	}
	
	@Override
	public UsuariosEnum getEnum() {
		return UsuariosEnum.ALUNO;
	}

}