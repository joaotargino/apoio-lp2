package interfaceUsuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controle.BD;
import controle.Sistema;
import controle.SistemaI;

public class UserInterface {
	
	static Scanner sc = new Scanner(System.in);
	final static int SENHA = 0;
	final static int USERNAME = 1;
	final static int USER_EMAIL = 2;
	
	//nao sao daqui
	static String logado;

	
	public static void main(String[] args) {
		paginaInicial();
	}

	private static void paginaInicial() {
		System.out.println("BEM VINDO AO SISTEMA");
		System.out.print("LOGIN: ");
		String login = sc.nextLine();
		System.out.print("SENHA: ");
		String senha = sc.nextLine();
		confereLoginSenha(login, senha);
	}

	private static void confereLoginSenha(String login, String senha) {
		if (auxConfereLoginSenha(login, senha)) {
			String tipoUsuario = tipoUsuario(login);
			List<String> dadosUsuario = dadosUsuario(login);
			//dadosUsuario.add(login);
			if (tipoUsuario == "aluno") {
				menuAluno(dadosUsuario);
			} else if (tipoUsuario == "monitor") {
				menuModerador(dadosUsuario);
			} else menuProfessor(dadosUsuario);
		} else {
			System.out.println("DADOS INCORRETOS!");
			paginaInicial();
		}
	}

	private static List<String> dadosUsuario(String login) {
		for (Usuario usuario : usuarios) {
			if (usuario.getLogin() == login) {
				return usuario.getDadosUsuario();
			}
		}
		return null;
	}

	//Soh pra testar. Nao vai ficar em interface

	
	public static boolean auxConfereLoginSenha(String login, String senha) {
		if (alunos.containsKey(login) && alunos.get(login).get(SENHA).equals(senha) ||
				monitores.containsKey(login) && monitores.get(login).get(SENHA).equals(senha)) {
				logado = login;
				return true;
		}
		return false;
	}
	
	public static String tipoUsuario (String login) {
		if (monitores.containsKey(login)) {
			return "monitor";
		} else if (alunos.containsKey(login)) {
			return "aluno";
		}
		else return "professor";
	}
	
	public static String logado() {
		return logado;
	}
	
	private static void listaTurmas(){
		//lista as turmas cadastradas. 
	}

	private static void menuProfessor(List<String> dadosUsuario) {
		
		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int VER_ALUNOS = 2;
		final int CRIAR_EXERCICIO = 3;
		final int CRIAR_ALUNO = 4;
		final int CRIAR_MONITOR = 5;
		
		System.out.println("Olá, " + dadosUsuario.get(USERNAME) + ", email: "+ dadosUsuario.get(USER_EMAIL));
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
			//o usuario escolhe pela matricula, tipo 20821205
			//ao ver o aluno, baixa o exercicio, seta a nota e poe o comentario do exercicio
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
		
		System.out.println("Olá, " + dadosUsuario.get(USERNAME) + ", email: "+ dadosUsuario.get(USER_EMAIL));
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
			//o usuario escolhe pela matricula, tipo 20821205
			//ao ver o aluno, baixa o exercicio, seta a nota e poe o comentario do exercicio
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
		
		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int VER_PLANILHA = 2;
		final int VER_EXERCICIO = 3;
		final int BAIXAR_EXERCICIO = 4;
		final int SUBMETER_EXERCICIO = 5;
		
		System.out.println("Olá, " + dadosUsuario.get(USERNAME) + ", email: "+ dadosUsuario.get(USER_EMAIL));
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
			editarDados(false, dadosUsuario);
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

//	private static void editarDados(boolean administrador, List<String> aluno) {
	private static void editarDados(boolean administrador, List<String> usuario) {
		List<String> dados = new ArrayList<String>();
		if (administrador) {
			// ??!?
		} else {
//			System.out.println("EDITAR DADOS DE ALUNO "+ aluno.get(USERNAME));//get(1) -- USAR POLIMORFISMO (usuario.get ?)
			System.out.println("EDITAR DADOS DE "+ usuario.get(USERNAME));
			System.out.println("NOME: ");
			dados.add(sc.nextLine());
			System.out.println("EMAIL: ");
			dados.add(sc.nextLine());
			System.out.println("SENHA ATUAL: ");
			dados.add(sc.nextLine());
			System.out.println("NOVA SENHA: ");
			dados.add(sc.nextLine());
			System.out.println("CONFIRMA NOVA SENHA: ");
			dados.add(sc.nextLine());
		}
		Sistema.editaDadosUsuario(dados);
	}
}
