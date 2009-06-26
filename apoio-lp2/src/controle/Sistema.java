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

public class Sistema {

	static List<Usuario> usuarios;

	public static void editaDadosUsuario(List<String> dados, UsuariosEnum tipo) {
		Usuario usr = criaUsuario(dados, tipo);

		BD.atualizaUsuario(usr);

	}

	private static Usuario criaUsuario(List<String> dados, UsuariosEnum tipo) {
		Usuario usr = null;
		if (tipo == UsuariosEnum.ALUNO) {
			System.out.println(dados.get(4));
			try {
				usr = new Aluno(dados.get(DadosUsuarioEnum.NOME.ordinal()), 
						dados.get(DadosUsuarioEnum.LOGIN.ordinal()), 
						dados.get(DadosUsuarioEnum.SENHA.ordinal()), 
						dados.get(DadosUsuarioEnum.MATRICULA.ordinal()), 
						dados.get(DadosUsuarioEnum.EMAIL.ordinal()), 
						dados.get(DadosUsuarioEnum.TURMA.ordinal()));
			} catch (Exception e) {
				System.out.println("catch");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (tipo == UsuariosEnum.PROFESSOR) {
			try {
				usr = new Professor(dados.get(DadosUsuarioEnum.NOME.ordinal()),
						dados.get(DadosUsuarioEnum.LOGIN.ordinal()),
						dados.get(DadosUsuarioEnum.SENHA.ordinal()),
						dados.get(DadosUsuarioEnum.MATRICULA.ordinal()),
						dados.get(DadosUsuarioEnum.EMAIL.ordinal()),
						dados.get(DadosUsuarioEnum.TURMA.ordinal()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				usr = new Moderador(dados.get(DadosUsuarioEnum.NOME.ordinal()),
						dados.get(DadosUsuarioEnum.LOGIN.ordinal()),
						dados.get(DadosUsuarioEnum.SENHA.ordinal()),
						dados.get(DadosUsuarioEnum.MATRICULA.ordinal()),
						dados.get(DadosUsuarioEnum.EMAIL.ordinal()),
						dados.get(DadosUsuarioEnum.TURMA.ordinal()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return usr;
	}

	public static List<Usuario> getUsuarios() {
		return usuarios;
	}

	public static List<String> dadosUsuario(String login) {
		for (Usuario usuario : usuarios) {
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
		System.out.println(login + " " + senha);
		Iterator<Usuario> it = BD.getUsuarios().iterator();
		while (it.hasNext()) {
			Usuario usr = it.next();
			// System.out.println(urlogin+ " " + senha);
			if (usr.getLogin().equals(login) && usr.getSenha().equals(senha)) {
				System.out.println("entrou no if");
				return tipoUsuario(usr);
			}
		}
		return null;
	}

	public static UsuariosEnum tipoUsuario(Usuario usr) {
		if (usr instanceof Professor) {
			return UsuariosEnum.PROFESSOR;
		} else if (usr instanceof Moderador) {
			return UsuariosEnum.MONITOR;
		}
		return UsuariosEnum.ALUNO;
	}

	public static void inicializa() {
		usuarios = BD.getUsuarios();
	}
	/**
	 * Soh estah enviando se estiver dentro do prazo estipulado para a entrega do exercicio
	 * @param login
	 * @param caminho
	 * @param idExercicio
	 * @return
	 */
	public static boolean enviarSubmissao(String login, String caminho, int idExercicio) {
		Submissao sub = new Submissao(login, new GregorianCalendar(), caminho);
		Exercicio exercicio = BD.getExercicio(idExercicio);
		if (sub.getDataDeEntrega().compareTo(exercicio.getDataEntrega()) < 0) {
			try {
				BD.cadastraSubmissao(sub);
			} catch (IOException e) {
				e.printStackTrace();
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
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void addUsuario(List<String> dadosUsuario, UsuariosEnum tipo) {
		Usuario usr = criaUsuario(dadosUsuario, tipo);

		try {
			BD.cadastraUsuario(usr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
