package users;

import controle.UsuariosEnum;

/**
 * Classe que cria um usuario do tipo moderador
 * @author Joao Paulo
 * @author Jessica Priscila
 * @author Erickson Filipe
 * @author Arnett Rufino
 *
 */
public class Moderador extends Usuario{

	public Moderador(int id, String nome, String login, String senha, String matricula, String email, String turma) throws Exception {
		super(id, nome, login, senha, matricula, email, turma);
	}
	
	@Override
	public UsuariosEnum getEnum() {
		return UsuariosEnum.MONITOR;
	}
	

}
