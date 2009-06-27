package controle;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import users.Aluno;
import users.Moderador;
import users.Professor;
import users.Usuario;
import disciplina.Exercicio;
/**
 * Classe que gerencia o sistema.
 * @author Joao Paulo
 * @author Jessica Priscila
 * @author Erickson Filipe
 * @author Arnett Rufino
 * 
 * @version 0.5 - 25 de junho de 2009
 */
public class Sistema {

	/**
	 * Edita os dados do usuario
	 * @param dados
	 * @param tipo
	 */
	public static void editaDadosUsuario(List<String> dados, UsuariosEnum tipo) {
		Usuario usr = criaUsuario(dados, tipo);

		BD.atualizaUsuario(usr);

	}

	/**
	 * Cria um usuario
	 * @param dados
	 * @param tipo
	 * @return o usuario criado
	 */
	public static Usuario criaUsuario(List<String> dados, UsuariosEnum tipo) {
		Usuario usr = null;
		if (tipo == UsuariosEnum.ALUNO) {
			
			try {
				usr = new Aluno(Util.geraId("usuario"), dados.get(DadosUsuarioEnum.NOME.ordinal()), 
						dados.get(DadosUsuarioEnum.LOGIN.ordinal()), 
						dados.get(DadosUsuarioEnum.SENHA.ordinal()), 
						dados.get(DadosUsuarioEnum.MATRICULA.ordinal()), 
						dados.get(DadosUsuarioEnum.EMAIL.ordinal()), 
						dados.get(DadosUsuarioEnum.TURMA.ordinal()));
			} catch (Exception e) {
				System.out.println(e);
			}
		} else if (tipo == UsuariosEnum.PROFESSOR) {
			try {
				usr = new Professor(Util.geraId("usuario"), dados.get(DadosUsuarioEnum.NOME.ordinal()),
						dados.get(DadosUsuarioEnum.LOGIN.ordinal()),
						dados.get(DadosUsuarioEnum.SENHA.ordinal()),
						dados.get(DadosUsuarioEnum.MATRICULA.ordinal()),
						dados.get(DadosUsuarioEnum.EMAIL.ordinal()),
						dados.get(DadosUsuarioEnum.TURMA.ordinal()));
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			try {
				usr = new Moderador(Util.geraId("usuario"), dados.get(DadosUsuarioEnum.NOME.ordinal()),
						dados.get(DadosUsuarioEnum.LOGIN.ordinal()),
						dados.get(DadosUsuarioEnum.SENHA.ordinal()),
						dados.get(DadosUsuarioEnum.MATRICULA.ordinal()),
						dados.get(DadosUsuarioEnum.EMAIL.ordinal()),
						dados.get(DadosUsuarioEnum.TURMA.ordinal()));
			} catch (Exception e) {
				System.out.println(e);
			}

		}
		return usr;
	}

	/**
	 * Retorna os usuarios cadastrados no banco de dados
	 * @return uma lista de usuarios
	 */
	public static List<Usuario> getUsuarios() {
		return BD.getUsuarios();
	}
	
	/**
	 * Muda a senha do usuario
	 * @param login
	 * @param senhaAntiga
	 * @param novaSenha
	 * @param confirmaNovaSenha
	 * @return true se foi possivel mudar a senha
	 */
	public static boolean mudaSenha(String login ,String senhaAntiga, String novaSenha, String confirmaNovaSenha) {
		Usuario usr = BD.getUsuario(login);
		if (usr.getSenha().equals(senhaAntiga) && novaSenha.equals(confirmaNovaSenha)) {
			try {
				usr.setSenha(novaSenha);
			} catch (Exception e) {
				return false;
			}
			BD.atualizaUsuario(usr);
			return true;
		}
		return false;
	}

	/**
	 * Retorna os dados de um usario
	 * @param login
	 * @return List<String> - os dados de um usuario 
	 */
	public static List<String> dadosUsuario(String login) {
		for (Usuario usuario : getUsuarios()) {
			if (usuario.getLogin().equals(login)) {
				return usuario.getDadosUsuario();
			}
		}
		return null;
	}

	/**
	 * faz login
	 * @return true se foi possivel se logar
	 * @throws Exception
	 */
	public static boolean login() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * faz logoff
	 */
	public static void logoff(){
		// TODO Auto-generated method stub
	}

	/**
	 * baixa um arquivo
	 * @param caminho
	 */
	public static void mandaBaixar(String caminho) {
		// TODO Auto-generated method stub
	}

	/**
	 * Envia a senha do usuario por e-mail
	 * @param login
	 * @param email
	 * @return true se foi possivel enviar a senha do usuario
	 */
	public static boolean enviaSenhaPorEmail(String login, String email) {
		List<Usuario> users = BD.getUsuarios();
		Iterator<Usuario> it = users.iterator();
		while (it.hasNext()) {
			Usuario user = it.next();
			if (user.getLogin().equals(login) && user.getEmail().equals(email)) {
				// TODO enviar por email a senha do usuario
				return true;
			}
		}
		return false;
	}

	/**
	 * Confere o login e senha do usuario
	 * @param login
	 * @param senha
	 * @return um tipo enum indicando o tipo de usuario
	 */
	public static UsuariosEnum confereLoginSenha(String login, String senha) {

		Iterator<Usuario> it = BD.getUsuarios().iterator();
		while (it.hasNext()) {
			Usuario usr = it.next();
			if (usr.getLogin().equals(login) && usr.getSenha().equals(senha)) {				
				return tipoUsuario(usr);
			}
		}
		return UsuariosEnum.INEXISTENTE;
	}

	/**
	 * retorna o tipo do usuario passado como parametro
	 * @param usr
	 * @return um tipo enum indicando o tipo de usuario
	 */
	public static UsuariosEnum tipoUsuario(Usuario usr) {
		if (usr instanceof Professor) {
			return UsuariosEnum.PROFESSOR;
		} else if (usr instanceof Moderador) {
			return UsuariosEnum.MONITOR;
		}
		return UsuariosEnum.ALUNO;
	}

	/**
	 * Envia a resposta de um exercicio se estiver dentro do
	 * prazo estipulado para a entrega do exercicio
	 * @param login
	 * @param caminho
	 * @param idExercicio
	 * @return true se foi possivel enviar
	 */
	public static boolean enviarSubmissao(String login, String caminho, int idExercicio) {
		Submissao sub = new Submissao(idExercicio, login, new GregorianCalendar(), caminho);
		Exercicio exercicio = BD.getExercicio(idExercicio);
		if (sub.getDataDeEntrega().compareTo(exercicio.getDataEntrega()) < 0) {
			try {
				BD.cadastraSubmissao(sub);
			} catch (IOException e) {
				System.out.println(e);
			}
			return true;
		} return false;
	}
	
	/**
	 * cadastra um exercicio
	 * @param id
	 * @param nome
	 * @param enunciado
	 * @param data
	 * @param dataEntrega
	 * @return true se foi possivel cadastrar o exercicio
	 */
	public static boolean cadastrarExercicio(int id, String nome,  String enunciado, Calendar data,
			Calendar dataEntrega) {
		try {
			Exercicio ex = new Exercicio(id, nome, enunciado, data, dataEntrega);
			if (! BD.getExercicios().contains(ex)) {
				BD.cadastraExercicio(ex);
				return true;
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	/**
	 * Adciona um usuario no sistema
	 * @param dadosUsuario
	 * @param tipo
	 * @throws IOException
	 */
	public static void addUsuario(List<String> dadosUsuario, UsuariosEnum tipo) throws IOException {
		Usuario usr = criaUsuario(dadosUsuario, tipo);
		BD.cadastraUsuario(usr);
		
	}

	/**
	 * Cadastra um exercicio no sistema
	 * @param dadosExercicio
	 * @throws Exception
	 */
	public static void addExercicio(List<String> dadosExercicio) throws Exception {
		Calendar dataAtual = new GregorianCalendar();
		Exercicio exercicio = new Exercicio( Util.geraId("exercicio"), 
				dadosExercicio.get(0), dadosExercicio.get(1), dataAtual, Util.criaCalendario(dadosExercicio.get(2)));
		BD.cadastraExercicio(exercicio);
	}

	/**
	 * remove um exercicio
	 * @param id
	 * @return true se foi possivel
	 */
	public static boolean removerExercicio(int id) {
		return BD.removeExercicio(id);
		
	}

	/**
	 * atualiza um exercicio no sistema
	 * @param id
	 * @param nome
	 * @param enunciado
	 * @param dataDeEntrega
	 * @return true se foi possivel atualizar
	 * @throws Exception
	 */
	public static boolean atualizarExercicio(int id, String nome,
			String enunciado, String dataDeEntrega) throws Exception {
		Calendar dataAtual = new GregorianCalendar();
		Calendar dataEntrega = Util.criaCalendario(dataDeEntrega);
		Exercicio exercicio = new Exercicio(id, nome, enunciado, dataAtual, dataEntrega);
		return BD.atualizaExercicio(id, exercicio);
		
	}

	/**
	 * retorna uma lista de exercicios
	 * @return List<Exercicio> uma lista de exercicios
	 */
	public static List<Exercicio> verExercicios() {
		return BD.getExercicios();
	}

	/**
	 * Lista os usuarios
	 * @return um string com os usuarios
	 */
	public static String listarUsuarios(){
		Iterator<Usuario> it = BD.getUsuarios().iterator();
		String dados = "";
		while (it.hasNext()) {
			dados += it.next().toString();
		}
		return dados;
	}

	/**
	 * Retorna a correcao para determinado exercicio
	 * @param idExercicio
	 * @param login
	 * @return a correcao para determinado exercicio em forma de string
	 */
	public static String getCorrecao(int idExercicio, String login) {
		List<Submissao> submissoes = BD.getSubmissoes();
		Iterator<Submissao> it = submissoes.iterator();
		while(it.hasNext()) {
			Submissao submissao = it.next();
			if (submissao.getIdExercicio() == idExercicio) {
				return submissao.getNota() +submissao.getComentario();
			}
		}
		return "";
	}
	
	/**
	 * Lista todas as submissoes
	 * @return List<Submissao> as submissoes
	 */
	public static List<Submissao> getsubmissoes() {
		List<Submissao> submissoes = BD.getSubmissoes();
		return submissoes;
	}

	/**
	 * Corrige uma submissao de um aluno
	 * @param loginModerador
	 * @param loginAluno
	 * @param idSubmissao
	 * @param nota
	 * @param comentarioLab
	 * @return true se foi possivel corrigir
	 */
	public static boolean corrigirSubmissao(String loginModerador, String loginAluno,
			int idSubmissao, double nota, String comentarioLab) {
		Iterator<Usuario> it = BD.getModeradores().iterator();
		while (it.hasNext()) {
			Usuario moderador = it.next();
			if (moderador.getLogin().equals(loginModerador)) {
				Submissao submissao = BD.getSubmissao(idSubmissao);
				submissao.setNota(nota);
				submissao.setComentario(comentarioLab);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * remove um usuario do sistema
	 * @param loginUsuario
	 * @param idUsuario
	 * @return true se foi possivel
	 */
	public static boolean removerUsuario(String loginUsuario, int idUsuario) {
		if (BD.getUsuario(loginUsuario) instanceof Professor) {
			BD.removeUsuario(idUsuario);
			return true;
		}
		return false;
	}
	
	/**
	 * prepara o sistema
	 */
	public static void inicia() {
		try {
			BD.cadastraUsuario(new Professor(Util.geraId("usuario"),
					"Raquel Vigolvino Lopes", "raquelvl", "123456", "matricula", "raquel@dsc.ufcg.edu.br", "2009.1"));
		} catch (Exception e) {
		}
		
	}
	
	/**
	 * reseta o banco de dados
	 * @param loginUsuario
	 */
	public static void resetaBD(String loginUsuario) {
		if (BD.getUsuario(loginUsuario) instanceof Professor) {
			BD.reset();
			inicia();
		}
	}

	/**
	 * remove todos os alunos do banco de dados
	 * @param login
	 */
	public static void removerTodosAlunos(String login) {
		if (BD.getUsuario(login) instanceof Professor)
			BD.resetAlunos();
	}

	/**
	 * remove todos os moderadores do banco de dados
	 * @param login
	 */
	public static void removerTodosModeradores(String login) {
		if (BD.getUsuario(login) instanceof Professor)
			BD.resetModeradores();
		
	}

	/**
	 * remove todos os exercicios e submissoes correspondentes do banco de dados
	 * @param login
	 */
	public static void removerTodosExercicios(String login) {
		if (BD.getUsuario(login) instanceof Professor) {
			BD.resetExercicios();
			removerTodasSubmissoes(login);
		}
		
	}

	/**
	 * remove todas as submissoes do banco de dados
	 * @param login
	 */
	public static void removerTodasSubmissoes(String login) {
		if (BD.getUsuario(login) instanceof Professor)
			BD.resetSubmissoes();
		
	}

}
