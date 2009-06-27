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
 * classe responsavel ppor gerenciar o sistema
 * @author Arnett, Erickson, Jessica e Joao
 * @version 0.5
 */
public class Sistema {

	public static void editaDadosUsuario(List<String> dados, UsuariosEnum tipo) {
		Usuario usr = criaUsuario(dados, tipo);

		BD.atualizaUsuario(usr);

	}

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

	public static List<Usuario> getUsuarios() {
		return BD.getUsuarios();
	}
	
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

	public static List<String> dadosUsuario(String login) {
		for (Usuario usuario : getUsuarios()) {
			if (usuario.getLogin().equals(login)) {
				return usuario.getDadosUsuario();
			}
		}
		return null;
	}

	public static boolean login() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean logoff() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public static void mandaBaixar(String caminho) {
		// TODO Auto-generated method stub
	}

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

	public static UsuariosEnum confereLoginSenha(String login, String senha) {

		Iterator<Usuario> it = BD.getUsuarios().iterator();
		while (it.hasNext()) {
			Usuario usr = it.next();
			// System.out.println(urlogin+ " " + senha);
			if (usr.getLogin().equals(login) && usr.getSenha().equals(senha)) {				
				return tipoUsuario(usr);
			}
		}
		return UsuariosEnum.INEXISTENTE;
	}

	public static UsuariosEnum tipoUsuario(Usuario usr) {
		if (usr instanceof Professor) {
			return UsuariosEnum.PROFESSOR;
		} else if (usr instanceof Moderador) {
			return UsuariosEnum.MONITOR;
		}
		return UsuariosEnum.ALUNO;
	}

	/**
	 * Soh estah enviando se estiver dentro do prazo estipulado para a entrega do exercicio
	 * @param login
	 * @param caminho
	 * @param idExercicio
	 * @return
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

	public static void addUsuario(List<String> dadosUsuario, UsuariosEnum tipo) throws IOException {
		Usuario usr = criaUsuario(dadosUsuario, tipo);
		BD.cadastraUsuario(usr);
		
	}

	public static void addExercicio(List<String> dadosExercicio) throws Exception {
		Calendar dataAtual = new GregorianCalendar();
		Exercicio exercicio = new Exercicio( Util.geraId("exercicio"), 
				dadosExercicio.get(0), dadosExercicio.get(1), dataAtual, Util.criaCalendario(dadosExercicio.get(2)));
		BD.cadastraExercicio(exercicio);
	}

	public static boolean removerExercicio(int id) {
		return BD.removeExercicio(id);
		
	}

	public static boolean atualizarExercicio(int id, String nome,
			String enunciado, String dataDeEntrega) throws Exception {
		Calendar dataAtual = new GregorianCalendar();
		Calendar dataEntrega = Util.criaCalendario(dataDeEntrega);
		Exercicio exercicio = new Exercicio(id, nome, enunciado, dataAtual, dataEntrega);
		return BD.atualizaExercicio(id, exercicio);
		
	}

	public static List<Exercicio> verExercicios() {
		return BD.getExercicios();
	}

	public static String listarUsuarios(){
		Iterator<Usuario> it = BD.getUsuarios().iterator();
		String dados = "";
		while (it.hasNext()) {
			dados += it.next().toString();
		}
		return dados;
	}


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
	
	public static List<Submissao> getsubmissoes() {
		List<Submissao> submissoes = BD.getSubmissoes();
		return submissoes;
	}


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

	public static boolean removerUsuario(String loginUsuario, int idUsuario) {
		if (BD.getUsuario(loginUsuario) instanceof Professor) {
			BD.removeUsuario(idUsuario);
			return true;
		}
		return false;
	}

	public static void inicia() {
		try {
			BD.cadastraUsuario(new Professor(Util.geraId("usuario"),
					"Raquel Vigolvino Lopes", "raquelvl", "123456", "matricula", "raquel@dsc.ufcg.edu.br", "2009.1"));
		} catch (Exception e) {
		}
		
	}
	
	public static void resetaBD(String loginUsuario) {
		if (BD.getUsuario(loginUsuario) instanceof Professor) {
			BD.reset();
			inicia();
		}
	}

}
