package users;
import graphic.Interface;

import java.io.Serializable;

import controle.ExercicioBD;
import controle.Sistema;
import disciplina.Exercicio;

public abstract class Usuario implements Serializable{
	private String login, nome, senha, email, matricula;

	/**
	 * Construtor padrao.
	 */
	private Usuario() {}
	
	public Usuario(String nome, String login, String senha, String matricula, String email) throws Exception {
		if (login == null || senha == null || nome == null) 
			throw new IllegalArgumentException("Argumentos nulos!");
		if (login.length() < 8 || senha.length() < 4 || !verificaEmail(email) || nome.isEmpty())
			throw new Exception("Argumentos invalidos!");
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
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
	 * 
	 * @return
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * 
	 * @param matricula
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
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
		Interface.exibirExercicios(Usuario.this);
	}
	
	public boolean baixarExercicio(String Login, Exercicio exercicio) {
		if (ExercicioBD.getExercicios().contains(exercicio)) {
			String caminho = SubmissaoBD.getSubmissao(exercicio)[0];
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
	
	public void verCorrecoes() {
		Interface.exibirCorrecoes(Usuario.this);
		
	}
	
	public void verCorrecao(Exercicio exercicio, String login) {
		Interface.exibirCorrecao(login, exercicio);
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
			 	if (dominio.contains("."))
			 		return true;
			} return false;
		} return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario usr = (Usuario) obj;
			if (usr.getLogin().equals(getLogin()))
				return true;
		}
		return false;
	}
}
