package interfaceUsuario;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import controle.BD;
import controle.DadosUsuarioEnum;
import controle.Sistema;
import controle.UsuariosEnum;

//TODO implementar trocar senha =x

public class UserInterface {

	static Scanner sc = new Scanner(System.in);

	static String logado;
	static UsuariosEnum tipoUsuario;

	public static void main(String[] args) {
		System.out.println(BD.getUsuarios().toString());
		System.out.println(BD.getUsuarios().get(0).getMatricula());// .getDadosUsuario());
		Sistema.inicializa();
		paginaInicial();
	}

	private static void paginaInicial() {
		System.out.println("BEM VINDO AO SISTEMA");
		System.out.print("LOGIN: ");
		String login = sc.nextLine();
		System.out.print("SENHA: ");
		String senha = sc.nextLine();
		tipoUsuario = Sistema.confereLoginSenha(login, senha);
		if (tipoUsuario != null) {
			if (tipoUsuario == UsuariosEnum.ALUNO) {
				menuAluno(Sistema.dadosUsuario(login));
			} else if (tipoUsuario == UsuariosEnum.MONITOR) {
				menuModerador(Sistema.dadosUsuario(login));
			} else {
				menuProfessor(Sistema.dadosUsuario(login)); // considerando que
				// o professor tah
				// add no msm arq
				// dos outros users
			}
		} else {
			System.out.println("DADOS INCORRETOS");
			paginaInicial();
		}
	}

	// public static boolean auxConfereLoginSenha(String login, String senha) {
	// if (alunos.containsKey(login) &&
	// alunos.get(login).get(SENHA).equals(senha) ||
	// monitores.containsKey(login) &&
	// monitores.get(login).get(SENHA).equals(senha)) {
	// logado = login;
	// return true;
	// }
	// return false;
	// }

	// public static String logado() {
	// return logado;
	// } ??????????

	private static void listaTurmas() {
		// err
	}

	private static void menuProfessor(List<String> dadosUsuario) {

		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int VER_ALUNOS = 2;
		final int CRIAR_EXERCICIO = 3;
		final int CRIAR_ALUNO = 4;
		final int CRIAR_MONITOR = 5;
		int opcao = -1;

		do {
			System.out.println("Olá, "
					+ dadosUsuario.get(DadosUsuarioEnum.NOME.ordinal())
					+ ", email: "
					+ dadosUsuario.get(DadosUsuarioEnum.EMAIL.ordinal()));
			System.out.println("MENU PROFESSOR");
			System.out.println("1 - EDITAR DADOS");
			System.out.println("2 - VER ALUNOS");
			System.out.println("3 - CRIAR EXERCICIO");
			System.out.println("4 - CRIAR ALUNO");
			System.out.println("5 - CRIAR MONITOR");
			System.out.println();
			System.out.println("0 - SAIR");
			System.out.println();
			System.out.println("ESCOLHA O NUMERO DA OPCAO");
			opcao = Entrada.recebeInteiro();
			switch (opcao) {

			case SAIR:
				System.out.print("PRESSIONE ENTER PARA ENCERRAR");
				sc.nextLine();
				break;
			case EDITAR_DADOS:
				editarDados(dadosUsuario);
				break;
			case VER_ALUNOS:
				// o usuario escolhe pela matricula, tipo 20821205
				// ao ver o aluno, baixa o exercicio, seta a nota e poe o
				// comentario
				// do exercicio
				break;
			case CRIAR_ALUNO:
				criarUsuario(UsuariosEnum.ALUNO);
				break;
			case CRIAR_MONITOR:
				criarUsuario(UsuariosEnum.MONITOR);
				break;
			case CRIAR_EXERCICIO:
				break;

			default:
				System.out.println("NUMERO INVALIDO");
			}

		} while (opcao != SAIR);

	}

	private static void menuModerador(List<String> dadosUsuario) {

		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int VER_ALUNOS = 2;
		final int CRIAR_EXERCICIO = 3;
		final int CRIAR_ALUNO = 4;
		int opcao = -1;

		do {
			System.out.println("Olá, "
					+ dadosUsuario.get(DadosUsuarioEnum.NOME.ordinal())
					+ ", email: "
					+ dadosUsuario.get(DadosUsuarioEnum.EMAIL.ordinal()));
			System.out.println("MENU MODERADOR");
			System.out.println("1 - EDITAR DADOS");
			System.out.println("2 - VER ALUNOS");
			System.out.println("3 - CRIAR EXERCICIO");
			System.out.println("4 - CRIAR ALUNO");
			System.out.println();
			System.out.println("0 - SAIR");
			System.out.println();
			System.out.println("ESCOLHA O NUMERO DA OPCAO");
			opcao = Entrada.recebeInteiro();
			switch (opcao) {
			case SAIR:
				System.out.print("PRESSIONE ENTER PARA ENCERRAR");
				sc.nextLine();
				break;
			case EDITAR_DADOS:
				editarDados(dadosUsuario);
				break;
			case VER_ALUNOS:
				// o usuario escolhe pela matricula, tipo 20821205
				// ao ver o aluno, baixa o exercicio, seta a nota e poe o
				// comentario
				// do exercicio
				break;
			case CRIAR_ALUNO:
				criarUsuario(UsuariosEnum.ALUNO);
				break;
			case CRIAR_EXERCICIO:
				break;

			default:
				System.out.println("NUMERO INVALIDO");
			}
		} while (opcao != SAIR);

	}

	private static void menuAluno(List<String> dadosUsuario) {

		System.out.println(dadosUsuario.get(1));
		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int VER_PLANILHA = 2;
		final int VER_EXERCICIO = 3;
		final int BAIXAR_EXERCICIO = 4;
		final int SUBMETER_EXERCICIO = 5;
		int opcao = -1;

		do {

			System.out.println("Olá, "
					+ dadosUsuario.get(DadosUsuarioEnum.NOME.ordinal())
					+ ", email: "
					+ dadosUsuario.get(DadosUsuarioEnum.EMAIL.ordinal()));
			System.out.println("MENU ALUNO");
			System.out.println("1 - EDITAR DADOS");
			System.out.println("2 - VER PLANILHA DE NOTAS");
			System.out.println("3 - VER EXERCICIOS");
			System.out.println("4 - BAIXAR EXERCICIO");
			System.out.println("5 - SUBMETER EXERCICIO");
			System.out.println();
			System.out.println("0 - SAIR");
			System.out.println();
			System.out.println("ESCOLHA O NUMERO DA OPCAO");
			opcao = Entrada.recebeInteiro();

			switch (opcao) {
			case SAIR:
				System.out.print("PRESSIONE ENTER PARA ENCERRAR");
				sc.nextLine();
				break;
			case EDITAR_DADOS:
				editarDados(dadosUsuario);
				break;
			case VER_PLANILHA:
				break;
			case VER_EXERCICIO:
				break;
			case BAIXAR_EXERCICIO:
				Sistema.mandaBaixar(caminho); // implementa, po!
				break;
			case SUBMETER_EXERCICIO:
				Sistema.subemeterExercicio(dadosUsuario
						.get(DadosUsuarioEnum.LOGIN.ordinal()), exercicio);
				break;

			default:
				System.out.println("NUMERO INVALIDO");
			}
		} while (opcao != SAIR);

	}

	private static void editarDados(List<String> usuario) {
		// List<String> dados = new ArrayList<String>();
		System.out.println("EDITAR DADOS DE "
				+ usuario.get(DadosUsuarioEnum.NOME.ordinal()));
		usuario.set(DadosUsuarioEnum.NOME.ordinal(), recebeDados("NOME: ",
				usuario.get(DadosUsuarioEnum.NOME.ordinal())));
		usuario.set(DadosUsuarioEnum.MATRICULA.ordinal(), recebeDados(
				"MATRICULA: ", usuario
						.get(DadosUsuarioEnum.MATRICULA.ordinal())));
		usuario.set(DadosUsuarioEnum.EMAIL.ordinal(), recebeDados("EMAIL: ",
				usuario.get(DadosUsuarioEnum.EMAIL.ordinal())));

		Sistema.editaDadosUsuario(usuario, tipoUsuario);
	}

	public static String recebeDados(String msg) {
		System.out.println(msg);
		String dado = sc.nextLine().trim();
		while (dado.isEmpty()) {
			System.out.println(msg);
			dado = sc.nextLine().trim();
		}
		return dado;
	}

	public static String recebeDados(String msg, String dadoAntigo) {
		System.out.println(msg);
		String dado = sc.nextLine().trim();
		if (dado.isEmpty()) {
			dado = dadoAntigo;
		}
		return dado;
	}

	public static void criarUsuario(UsuariosEnum tipo) {
		List<String> dadosUsuario = new ArrayList<String>();

		dadosUsuario.add(recebeDados("LOGIN: "));
		dadosUsuario.add(recebeDados("SENHA: "));
		dadosUsuario.add(recebeDados("MATRICULA: "));
		dadosUsuario.add(recebeDados("NOME: "));
		dadosUsuario.add(recebeDados("EMAIL: "));
		dadosUsuario.add(recebeDados("TURMA: "));
		
		Sistema.addUsuario(dadosUsuario, tipo);
	}
	
	public static void enviarSenhaPorEmail() {
		String login = recebeDados("LOGIN: ");
		String email = recebeDados("EMAIL: ");
		Sistema.enviaSenhaPorEmail(login, email);
	}
	
	public static void enviarSubmissao() {
		String login = recebeDados("LOGIN: ");
		String caminho = recebeDados("CAMINHO: ");
		int idExercicio = Integer.parseInt(recebeDados("ID EXERCICIO: "));
		Sistema.enviarSubmissao(login, caminho, idExercicio);
	}
	
	private static Calendar criaCalendario(String cal) {
		String[] date = cal.split("/");
		return new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
	}
	
	public static void cadastrarExercicio(UsuariosEnum user) {
		if (user == UsuariosEnum.PROFESSOR || user == UsuariosEnum.MONITOR) {
			int id = Integer.parseInt(recebeDados("ID EXERCICIO: "));
			String nome = recebeDados("NOME: ");
			String enunciado = recebeDados("ENUNCIADO: ");
			Calendar data = new GregorianCalendar();
			Calendar dataDeEntrega = criaCalendario(recebeDados("DATA DE ENTREGA: "));
			Sistema.cadastrarExercicio(id, nome, enunciado, data, dataDeEntrega);
		}
	}
}
