package users;
import graphic.*;
import controle.*;

public abstract class Usuario {
	private String login, nome, senha, email;

	/**
	 * Construtor padrao.
	 */
	public Usuario(String nome, String login, String senha, String matricula, String email) throws Exception{
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
	
	//Exibe os exercicios do aluno, em forma de links
	public void verExercicios() {
		Interface.exibirExercicios(getLogin());
	}
	
	public boolean baixarExercicio(String Login, Exercicio exercicio) {
		if (BD.getExercicios().contains(exercicio)) {
			String caminho = BD.getSubmissao(exercicio)[0];
			//TODO averiguar se a posicao do caminho eh realmente a primeira
			Sistema.mandaBaixar(caminho);
			//Com o caminho do exercicio em maos, deve-se abrir uam janelinha de opcao de
			//salvar ou abrir o exercicio
			return true;
		} return false;
	}
	
	public void verPlanilhaDeNotas(){
		Interface.exibirPlanilhaDeNotas();
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
