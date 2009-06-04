package users;

public abstract class Usuario {

	// falta fzr login(off), integrar com
	// exercicios

	private String senha;
	private String matricula;
	private String email;
	private String login;

	public Usuario(String login, String senha, String matricula, String email) {
		this.login = login;
		this.senha = senha;
		this.matricula = matricula;
		this.email = email;
	}

	public String getSenha(String senha) throws Exception {
		return this.senha;
	}

	public String getMatricula(String matricula) throws Exception {
		return this.matricula;
	}

	public String getEmail(String email) {
		return this.email;
	}

	public String getLogin(String login) throws Exception {
		return this.login;
	}

	public void setLogin(String login) throws Exception {
		this.login = login;
	}

	public void setSenha(String senha) throws Exception {
		this.senha = senha;
	}

	public void setMatricula(String matricula) throws Exception {
		this.matricula = matricula;
	}

	public void setEmail(String email) throws Exception {
		this.email = email;
	}

}
