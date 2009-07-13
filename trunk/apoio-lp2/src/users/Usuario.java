package users;

import interfaceUsuario.IO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controle.BD;
import controle.UsuariosEnum;

/**
 * Classe que cria um usuario do tipo aluno
 * @author Joao Paulo
 * @author Jessica Priscila
 * @author Erickson Filipe
 * @author Arnett Rufino
 *
 */
public class Usuario implements Serializable {
	
	
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
		if (login == null || senha == null || nome == null || matricula == null || 
				isOnlySpace(login) || isOnlySpace(senha) || isOnlySpace(nome) || isOnlySpace(matricula))
			throw new IllegalArgumentException(
					"NOME, MATRICULA, LOGIN OU SENHA  INVALIDOS!");
		
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
					"EMAIL INVALIDO. VERIFIQUE O ENDERECO E TENTE NOVAMENTE.");
		}

		if (nome.isEmpty()) {
			throw new Exception("INFORME UM NOME VALIDO");
		}
		this.id = util.Util.geraId("usuario");
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
	 * @param novaSenha
	 * @throws Exception 
	 */
	public void setSenha(String novaSenha) throws Exception {
		if (novaSenha == null) {
			throw new Exception();
		}
		if (isOnlySpace(novaSenha)) {
			throw new Exception("SENHA INVALIDA. ESPACOS NÃO SÃO VÁLIDOS COMO SENHA.");
		}
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
		if (!isOnlySpace(nome))
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
		if (!isOnlySpace(matricula) || matricula != null)
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
	 * Verifica se a string só tem espaço
	 * 
	 * @param string
	 *            - a string a ser verificada se só tem espaços
	 * @return true se só tem espaços, false caso contrário.
	 */
	private boolean isOnlySpace(String string) {
		int space = 0;
		for (int letter = 0; letter < string.length(); letter++) {
			if (Character.isSpaceChar(string.charAt(letter))) {
				space++;
			}
		}

		if (space == string.length()) {
			return true;
		}
		return false;
	}

	/**
	 * Verifica se a estrutura do e-mail eh valida.
	 * 
	 * @param email
	 * @return true caso o e-mail seja valido e false caso contrario.
	 */
	private boolean verificaEmail(String email) {
		if (email == null) return false;
		String expression = "^[\\w\\-]+(\\.[\\w\\-]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$";
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher pesquisa = pattern.matcher(email);
		if (pesquisa.matches()) {
			return true;
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
		return "ID: " + getId() + " | Login: " + getLogin() + " | Nome: " + getNome() + " | email: "+ getEmail() + " | Turma: "+ getTurma() + IO.NOVA_LINHA;
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
