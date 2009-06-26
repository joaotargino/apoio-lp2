package users;

public class Professor extends Moderador{
	public Professor(String nome, String login, String senha, String matricula, String email, String turma) throws Exception {
		super(nome, login, senha, matricula, email, turma);
	}

}
