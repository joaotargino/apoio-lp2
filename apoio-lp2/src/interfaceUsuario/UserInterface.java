package interfaceUsuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import users.Usuario;

import controle.BD;
import controle.Sistema;
import controle.SistemaI;
import controle.UsuariosEnum;

//TODO implementar trocar senha =x

public class UserInterface {

	static Scanner sc = new Scanner(System.in);
	final static int LOGIN = 0;
	final static int SENHA = 1;
	final static int MATRICULA = 2;
	final static int NOME = 3;
	final static int EMAIL = 4;

	static String logado;

	public static void main(String[] args) {
		System.out.println(BD.getUsuarios().toString());
		System.out.println(BD.getUsuarios().get(0).getDadosUsuario());
		Sistema.inicializa();
		paginaInicial();
	}

	private static void paginaInicial() {
		System.out.println("BEM VINDO AO SISTEMA");
		System.out.print("LOGIN: ");
		String login = sc.nextLine();
		System.out.print("SENHA: ");
		String senha = sc.nextLine();
		UsuariosEnum tipoUsuario = Sistema.confereLoginSenha(login, senha);
		if (tipoUsuario != null) {
			System.out.println("chegou " + tipoUsuario.name());
			if (tipoUsuario == UsuariosEnum.ALUNO) {
				System.out.println("aluno =D " + login);
				System.out.println(Sistema.getUsuarios());
				System.out.println(Sistema.dadosUsuario(login));

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

	public static String logado() {
		return logado;
	}

	private static void listaTurmas() {
		// lista as turmas cadastradas.
	}

	private static void menuProfessor(List<String> dadosUsuario) {

		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int VER_ALUNOS = 2;
		final int CRIAR_EXERCICIO = 3;
		final int CRIAR_ALUNO = 4;
		final int CRIAR_MONITOR = 5;

		System.out.println("Olá, " + dadosUsuario.get(NOME) + ", email: "
				+ dadosUsuario.get(EMAIL));
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
		int opcao = Entrada.recebeInteiro();
		sc.nextLine();

		switch (opcao) {
		case SAIR:
			System.out.print("PRESSIONE ENTER PARA ENCERRAR");
			sc.nextLine();
			break;
		case EDITAR_DADOS:
			editarDados(false, dadosUsuario);
			break;
		case VER_ALUNOS:
			// o usuario escolhe pela matricula, tipo 20821205
			// ao ver o aluno, baixa o exercicio, seta a nota e poe o comentario
			// do exercicio
			break;
		case CRIAR_ALUNO:
			break;
		case CRIAR_MONITOR:
			break;
		case CRIAR_EXERCICIO:
			break;

		default:
			System.out.println("NUMERO INVALIDO");
		}

	}

	private static void menuModerador(List<String> dadosUsuario) {

		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int VER_ALUNOS = 2;
		final int CRIAR_EXERCICIO = 3;
		final int CRIAR_ALUNO = 4;

		System.out.println("Olá, " + dadosUsuario.get(NOME) + ", email: "
				+ dadosUsuario.get(EMAIL));
		System.out.println("MENU MODERADOR");
		System.out.println("1 - EDITAR DADOS");
		System.out.println("2 - VER ALUNOS");
		System.out.println("3 - CRIAR EXERCICIO");
		System.out.println("4 - CRIAR ALUNO");
		System.out.println();
		System.out.println("0 - SAIR");
		System.out.println();
		System.out.println("ESCOLHA O NUMERO DA OPCAO");
		int opcao = Entrada.recebeInteiro();
		sc.nextLine();

		switch (opcao) {
		case SAIR:
			System.out.print("PRESSIONE ENTER PARA ENCERRAR");
			sc.nextLine();
			break;
		case EDITAR_DADOS:
			editarDados(false, dadosUsuario);
			break;
		case VER_ALUNOS:
			// o usuario escolhe pela matricula, tipo 20821205
			// ao ver o aluno, baixa o exercicio, seta a nota e poe o comentario
			// do exercicio
			break;
		case CRIAR_ALUNO:
			break;
		case CRIAR_EXERCICIO:
			break;

		default:
			System.out.println("NUMERO INVALIDO");
		}

	}

	private static void menuAluno(List<String> dadosUsuario) {

		System.out.println(dadosUsuario.get(1));
		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int VER_PLANILHA = 2;
		final int VER_EXERCICIO = 3;
		final int BAIXAR_EXERCICIO = 4;
		final int SUBMETER_EXERCICIO = 5;

		System.out.println("Olá, " + dadosUsuario.get(NOME) + ", email: "
				+ dadosUsuario.get(EMAIL));
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
		int opcao = Entrada.recebeInteiro();

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
			break;
		case SUBMETER_EXERCICIO:
			break;

		default:
			System.out.println("NUMERO INVALIDO");
		}

	}

	private static void editarDados(List<String> usuario) {
		List<String> dados = new ArrayList<String>();

		System.out.println("EDITAR DADOS DE " + usuario.get(NOME));
		dados.add(recebeDados("NOME: ", usuario.get(NOME)));
		dados.add(recebeDados("MATRICULA: ", usuario.get(MATRICULA)));
		dados.add(recebeDados("EMAIL: ", usuario.get(EMAIL)));
		
		Sistema.editaDadosUsuario(dados);
	}

	public static String recebeDados(String msg, String dadoAntigo) {
		System.out.println(msg);
		String dado = sc.nextLine().trim();
		if (dado.isEmpty()) {
			dado = dadoAntigo;
		}
		return dado;
	}
}
