package controle;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import disciplina.Exercicio;

import users.*;

public class Sistema {

	static List<Usuario> usuarios;

	public static void editaDadosUsuario(List<String> dados, UsuariosEnum tipo) {
		Usuario usr = null;
		if (tipo == UsuariosEnum.ALUNO) {
			System.out.println(dados.get(4));
			try {
				usr = new Aluno(dados.get(DadosUsuarioEnum.NOME.ordinal()), dados
						.get(DadosUsuarioEnum.LOGIN.ordinal()), dados
						.get(DadosUsuarioEnum.SENHA.ordinal()), dados
						.get(DadosUsuarioEnum.MATRICULA.ordinal()), dados
						.get(DadosUsuarioEnum.EMAIL.ordinal()), dados
						.get(DadosUsuarioEnum.TURMA.ordinal()));
			} catch (Exception e) {
				System.out.println("catch");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (tipo == UsuariosEnum.PROFESSOR) {
			try {
				usr = new Professor(dados.get(DadosUsuarioEnum.NOME.ordinal()), dados
						.get(DadosUsuarioEnum.LOGIN.ordinal()), dados
						.get(DadosUsuarioEnum.SENHA.ordinal()), dados
						.get(DadosUsuarioEnum.MATRICULA.ordinal()), dados
						.get(DadosUsuarioEnum.EMAIL.ordinal()), dados
						.get(DadosUsuarioEnum.TURMA.ordinal()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				usr = new Moderador(dados.get(DadosUsuarioEnum.NOME.ordinal()), dados
						.get(DadosUsuarioEnum.LOGIN.ordinal()), dados
						.get(DadosUsuarioEnum.SENHA.ordinal()), dados
						.get(DadosUsuarioEnum.MATRICULA.ordinal()), dados
						.get(DadosUsuarioEnum.EMAIL.ordinal()), dados
						.get(DadosUsuarioEnum.TURMA.ordinal()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		BD.atualizaUsuario(usr);

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

	public static boolean mandaSenhaPorEmail(String login, String email) {
		Map<String, Usuario> usrs = BD.getUsuarios();
		if (usrs.containsKey(login)
				&& usrs.get(login).getEmail().equalsIgnoreCase(email)) {
			// TODO enviar por email a senha do usuario
			return true;
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

	public static boolean subemeterExercicio(String login, Exercicio exercicio) {
		// TODO Colocar data limite de entrega...
		if (BD.getExercicios().contains(exercicio)) {
			String[] sub = Interface.subemeterExercicio();
			// transformar a data em Gregorian Calendar (sub[1])
			Submissao submissao = new Submissao(sub[0],
					new GregorianCalendar(), sub[2]);
			try {
				BD.cadastraSubmissao(submissao);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}

}
