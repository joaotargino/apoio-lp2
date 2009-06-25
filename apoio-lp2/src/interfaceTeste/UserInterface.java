package interfaceTeste;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controle.Sistema;
import controle.SistemaI;

public class UserInterface {
	
	static Scanner sc = new Scanner(System.in);
	final static int USERNAME = 1;
	final static int USER_EMAIL = 2;
	
	//nao sao daqui
	static String logado;
	static Map<String, List<String>> alunos = new HashMap<String, List<String>>();
	static Map<String, List<String>> monitores = new HashMap<String, List<String>>();
	
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
			} else menuProfessor();
		} else {
			System.out.println("DADOS INCORRETOS!");
			paginaInicial();
		}
	}

	private static List<String> dadosUsuario(String login) {
		return alunos.get(login);
	}

	//Soh pra testar. Nao vai ficar em interface
	public static void inicializa() {
		alunos.put("20821205", Arrays.asList("12345", "jessica", "jessica@gmail.com"));;
		alunos.put("20821202", Arrays.asList("12345", "joao", "joaotargino@gmail.com"));
		alunos.put("20821203", Arrays.asList("12345", "erickson", "ericksonfilipe@gmail.com"));
		alunos.put("20821204", Arrays.asList("12345", "arnett", "shrivelfigs@gmail.com"));
		alunos.put("20821200", Arrays.asList("12345", "aluno", "aluno@gmail.com"));
		
		monitores.put("20821000", Arrays.asList("12345", "carla", "carla@gmail.com"));
		monitores.put("20821000", Arrays.asList("12345", "ricardo", "ricardo@gmail.com"));
		monitores.put("20821000", Arrays.asList("12345", "filipe", "filipe@gmail.com"));
	}
	
	public static boolean auxConfereLoginSenha(String login, String senha) {
		inicializa();
		if (alunos.containsKey(login) && alunos.get(login).get(0).equals(senha) ||
				monitores.containsKey(login) && monitores.get(login).get(0).equals(senha)) {
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
	
	private static void menuTurmas(){
		
	}

	private static void menuProfessor() {
		
		// TODO Auto-generated method stub
		
	}

	private static void menuModerador(List<String> dadosUsuario) {
		
		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int VER_TURMAS = 2;
		final int VER_PLANILHA = 3;
		//final int BAIXAR_PLANILHA = 4;
		final int SUBMETER_EXERCICIO = 5;
		
		System.out.println("Olá, " + dadosUsuario.get(USERNAME) + ", email: "+ dadosUsuario.get(USER_EMAIL));
		System.out.println("MENU MODERADOR");
		System.out.println("1 - EDITAR DADOS");
		System.out.println("2 - VER TURMAS");
		System.out.println("3 - VER/ATUALIZAR PLANILHA DE NOTAS");
		//System.out.println("4 - BAIXAR EXERCICIO");
		System.out.println("5 - SUBMETER EXERCICIO");
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
		case VER_TURMAS:
			break;
		case VER_EXERCICIO:
			break;
//		case BAIXAR_PLANILHA:
//			break;
		case SUBMETER_EXERCICIO:
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
		//final int BAIXAR_EXERCICIO = 4;
		final int SUBMETER_EXERCICIO = 5;
		
		System.out.println("Olá, " + dadosUsuario.get(USERNAME) + ", email: "+ dadosUsuario.get(USER_EMAIL));
		System.out.println("MENU ALUNO");
		System.out.println("1 - EDITAR DADOS");
		System.out.println("2 - VER PLANILHA DE NOTAS");
		System.out.println("3 - VER EXERCICIOS");
		//System.out.println("4 - BAIXAR EXERCICIO");
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
//		case BAIXAR_EXERCICIO:
//			break;
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
