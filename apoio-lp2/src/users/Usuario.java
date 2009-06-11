package users;

/**
 * Classe Usuario do projeto apoio-lp2
 * @author Erickson
 * @version 1.0 10 de junho de 2009 - 10:22h
 */
public abstract class Usuario {
	private String login, nome, senha, email;

	/**
	 * Construtor padrao.
	 */
	public Usuario(String login, String senha, String nome, String email) throws Exception{
		if (login == null || login.length() < 8 ||senha == null || senha.length() < 4 ||
				nome == null || !verificaEmail(email)) {
			throw new Exception("Nao passou pelo construtor.");
		}
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
	}
	
	/**
	 * Informa o login do usuario.
	 * @return login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}
	
	/**
	 * Modifica a senha do usuario.
	 * @param atual
	 * @param novaSenha
	 * @return true se a senha foi alterada e false caso contrario.
	 */
	public boolean setSenha(String atual, String novaSenha) {
		if (atual.equals(senha)) {
			senha = novaSenha;
			return true;
		} return false;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Informa o email.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Modifica o email.
	 * @param email
	 * @return true se o e-mail for valido e false caso contrario.
	 */
	public boolean setEmail(String email) {
		if (verificaEmail(email)) {
			this.email = email;
			return true;
		} return false;
	}

	//Metodo da Classe Sistema
	/**
	 * Envia a senha por email.
	 * @param login
	 * @return true caso a senha seja enviada e false caso contrario.
	 */
	public static boolean mandaSenhaPorEmail(String login) {
		if (login.equals("20821200")) {
			System.out.println("Enviando por e-mail!");
			return true;
		} return false;
		
	}
	
	/**
	 * Verifica se a estrutura do e-mail eh valida.
	 * @param email
	 * @return true caso o e-mail seja valido e false caso contrario.
	 */
	private boolean verificaEmail(String email) {
		if (email.contains("@") && email != null) {
			if (email.split("@")[0].length() > 0) {
				String dominio = email.split("@")[1];
			 	if (email.contains("."))
			 		return true;
			} return false;
		} return false;
	}
}
