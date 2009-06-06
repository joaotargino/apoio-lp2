package users;

public abstract class Usuario {

	// falta fzr login(off), integrar com
	// exercicios

	private String senha;
	private String matricula;
	private String email;
	private String login;
	private String nome;

	public Usuario(String nome, String login, String senha, String matricula,
			String email) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.matricula = matricula;
		this.email = email;
	}

	public String getSenha() throws Exception {
		return this.senha;
	}

	public String getNome() throws Exception {
		return this.nome;
	}

	public String getMatricula() throws Exception {
		return this.matricula;
	}

	public String getEmail() {
		return this.email;
	}

	public String getLogin() throws Exception {
		return this.login;
	}

	public void setNome(String nome) throws Exception {
		this.nome = nome;
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
