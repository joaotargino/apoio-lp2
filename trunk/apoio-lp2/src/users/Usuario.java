package users;

import interfaceUsuario.IO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import controle.UsuariosEnum;

/**
 * Classe que cria um usuario do tipo aluno
 * @author Joao Paulo
 * @author Jessica Priscila
 * @author Erickson Filipe
 * @author Arnett Rufino
 *
 */
public abstract class Usuario implements Serializable {
	
	
	private String login, nome, senha, email, matricula, turma;
	private int id;
	final int MENOR_LOGIN = 5;
	final int MENOR_SENHA = 5;
	final int MAIOR_SENHA = 18;

	/**
	 * Construtor padrao.
	 */
	public Usuario(String nome, String login, String senha, String matricula,
			String email, String turma) throws Exception {
		if (login == null || senha == null || nome == null)
			throw new IllegalArgumentException(
					"LOGIN, NOME OU SENHA INVALIDOS!");
		if (login.length() < MENOR_LOGIN) {
			throw new Exception(
					"LOGIN MUITO CURTO! INFORME UM LOGIN COM MAIS DE 4 CARACTERES.");
		}
		if (senha.length() < MENOR_SENHA) {
			throw new Exception(
					"SENHA INVALIDA. INFORME UMA SENHA ENTRE SEIS E DEZOITO CARACTERES.");
		}
		if (senha.length() > MAIOR_SENHA) {
			throw new Exception(
					"SENHA INVALIDA. INFORME UMA SENHA ENTRE SEIS E DEZOITO CARACTERES.");
		}
		if (!verificaEmail(email)) {
			throw new Exception(
					"EMAIL INVALIDO. VERIFIQUE O ENDEREÇO E TENTE NOVAMENTE.");
		}

		if (nome.isEmpty()) {
			throw new Exception("INFORME UM NOME VALIDO");
		}
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
		this.turma = turma;
	}

	/**
	 * Informa o login do usuario.
	 * 
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
	 * 
	 * @param atual
	 * @param novaSenha
	 * @return true se a senha foi alterada e false caso contrario.
	 * @throws Exception 
	 */
	public void setSenha(String novaSenha) throws Exception {
		if (novaSenha.length() < MENOR_SENHA) {
			throw new Exception(
					"SENHA INVALIDA. INFORME UMA SENHA ENTRE SEIS E DEZOITO CARACTERES.");
		}
		if (novaSenha.length() > MAIOR_SENHA) {
			throw new Exception(
					"SENHA INVALIDA. INFORME UMA SENHA ENTRE SEIS E DEZOITO CARACTERES.");
		}
		senha = novaSenha;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * @return matricula
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
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Modifica o email.
	 * 
	 * @param email
	 * @return true se o e-mail for valido e false caso contrario.
	 */
	public boolean setEmail(String email) {
		if (verificaEmail(email)) {
			this.email = email;
			return true;
		}
		return false;
	}

	/**
	 * @return the turma
	 */
	public String getTurma() {
		return turma;
	}

	/**
	 * @param turma
	 *            the turma to set
	 */
	public void setTurma(String turma) {
		this.turma = turma;
	}

	/**
	 * Verifica se a estrutura do e-mail eh valida.
	 * 
	 * @param email
	 * @return true caso o e-mail seja valido e false caso contrario.
	 */
	private boolean verificaEmail(String email) {
		if (email.contains("@") && email != null) {
			if (email.split("@")[0].length() > 0) {
				String dominio = email.split("@")[1];
				if (dominio.contains("."))
					return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Usuario) {
			Usuario usr = (Usuario) obj;
			if (usr.getLogin().equals(getLogin())
					|| usr.getMatricula().equals(getMatricula())
					|| usr.getEmail().equals(getEmail())) {
				
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return "Login: " + getLogin() + " | Nome: " + getNome() + " - "+ getEnum()  + IO.NOVA_LINHA;
	}
	
	/**
	 * @return retorna o tipo do usuario
	 */
	public UsuariosEnum getEnum() {
		return UsuariosEnum.INEXISTENTE;
	}

	/**
	 * @return retorna uma lista de dados do usuario
	 */
	public List<String> getDadosUsuario() {
		List<String> dados = new ArrayList<String>();
		Collections.addAll(dados, getLogin(), getSenha(), getMatricula(),
				getNome(), getEmail(), getTurma());
		return dados;
	}
	


}
