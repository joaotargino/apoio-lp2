package interfaceUsuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import controle.DadosUsuarioEnum;
import controle.Sistema;
import controle.Submissao;
import controle.UsuariosEnum;
import disciplina.Exercicio;

/**
 * Interface com o usuario em modo texto
 * @author Joao Paulo
 * @author Jessica Priscila
 * @author Erickson Filipe
 * @author Arnett Rufino
 * @version 0.5  -  Junho / 2009
 */
public class UserInterface {

//teste netbeans 6.5 r147... usar essa versao que ta lendo isso!

	static Scanner sc = new Scanner(System.in);

	static String logado;
	static UsuariosEnum tipoUsuario;

	public static void main(String[] args) {
		Sistema.inicia();
		paginaInicial();
	}

	/**
	 * Apresentacao do sistema, onde o usuario faz login para acessar o sistema.
	 */
	private static void paginaInicial() {
		System.out.println("BEM VINDO AO SISTEMA");
		System.out.print("LOGIN: ");
		String login = sc.nextLine();
		System.out.print("SENHA: ");
		String senha = sc.nextLine();
		tipoUsuario = Sistema.confereLoginSenha(login, senha);
		if (tipoUsuario != UsuariosEnum.INEXISTENTE) {
			if (tipoUsuario == UsuariosEnum.ALUNO) {
				menuAluno(Sistema.dadosUsuario(login));
			} else if (tipoUsuario == UsuariosEnum.MONITOR) {
				menuModerador(Sistema.dadosUsuario(login));
			} else {
				menuProfessor(Sistema.dadosUsuario(login));
			}
		} else {
			System.out.println("DADOS INCORRETOS");
			paginaInicial();
		}
	}

	/**
	 * exibe o menu do professor, com as opcoes disponiveis para este usuario
	 * @param dadosUsuario - lista com os dados do usuario
	 */
	private static void menuProfessor(List<String> dadosUsuario) {

		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int TROCAR_SENHA = 2;
		final int VER_USUARIOS = 3;
		final int CRIAR_EXERCICIO = 4;
		final int REMOVER_EXERCICIO = 5;
		final int ATUALIZAR_EXERCICIO = 6;
		final int VER_EXERCICIOS = 7;
		final int VER_CORRECAO = 8;
		final int VER_SUBMISSOES = 9;
		final int CORRIGIR_SUBMISSAO = 10;
		final int CRIAR_ALUNO = 11;
		final int CRIAR_MONITOR = 12;
		final int REMOVER_USUARIO = 13;
		final int REMOVER_ALUNOS = 14;
		final int REMOVER_SUBMISSOES = 15;
		final int REMOVER_EXERCICIOS = 16;
		final int RESETAR_BD = 17;
		int opcao = -1;

		do {
			System.out.println(IO.NOVA_LINHA + "Ola, "
					+ dadosUsuario.get(DadosUsuarioEnum.NOME.ordinal())
					+ ", email: "
					+ dadosUsuario.get(DadosUsuarioEnum.EMAIL.ordinal()));
			System.out.println(IO.NOVA_LINHA + "MENU PROFESSOR");
			System.out.println("1 - EDITAR DADOS");
			System.out.println("2 - TROCAR SENHA");
			System.out.println("3 - VER USUARIOS");
			System.out.println("4 - CRIAR EXERCICIO");
			System.out.println("5 - REMOVER EXERCICIO");
			System.out.println("6 - ATUALIZAR EXERCICIO");
			System.out.println("7 - VER EXERCICIOS");
			System.out.println("8 - VER CORRECAO");
			System.out.println("9 - VER SUBMISSOES");
			System.out.println("10 - CORRIGIR SUBMISSAO");
			System.out.println("11 - CRIAR ALUNO");
			System.out.println("12 - CRIAR MONITOR");
			System.out.println("13 - REMOVER USUARIO");
			System.out.println("14 - REMOVER ALUNOS");
			System.out.println("15 - REMOVER SUBMISSOES");
			System.out.println("16 - REMOVER EXERCICIOS");
			System.out.println("17 - RESETAR BD");
			System.out.println();
			System.out.println("0 - SAIR");
			System.out.println();
			System.out.print("ESCOLHA O NUMERO DA OPCAO: ");
			opcao = IO.recebeInteiro();
			switch (opcao) {

			case SAIR:
				System.out.print("PRESSIONE ENTER PARA ENCERRAR");
				sc.nextLine();
				break;
			case EDITAR_DADOS:
				editarDados(dadosUsuario);
				break;
			case TROCAR_SENHA:
				mudarSenha(dadosUsuario);
				break;
			case VER_USUARIOS:
				verUsuarios();
				break;
			case CRIAR_ALUNO:
				try {

					criarUsuario(UsuariosEnum.ALUNO);
				} catch (IOException e) {
					System.out.println("Dados Invalidos!");
				}
				break;
			case CRIAR_MONITOR:
				try {
					criarUsuario(UsuariosEnum.MONITOR);
				} catch (IOException e) {
					System.out.println("Dados Invalidos!");
				}
				break;
			case CRIAR_EXERCICIO:
				try {
					criarExercicio();
				} catch (Exception e) {
					System.out.println("Dados Invalidos!");
				}
				break;

			case REMOVER_EXERCICIO:
				if (removerExercicio())
					System.out.println("Exercicio removido com sucesso!");
				else
					System.out.println("id invalido!");
				break;

			case ATUALIZAR_EXERCICIO:
				try {
					if (atualizarExercicio())
						System.out.println("Exercicio atualizado com sucesso!");
					else
						System.out
								.println("Nao foi possivel atualizar o exercicio!");
				} catch (Exception e) {
					System.out.println("Dados Invalidos!");
				}
				break;

			case VER_EXERCICIOS:
				verExercicios();
				break;
				
			case VER_SUBMISSOES:
				verSubmissoes(dadosUsuario);
				
			case VER_CORRECAO:
				verCorrecao(dadosUsuario);
				break;
			case CORRIGIR_SUBMISSAO:
				corrigirSubmissao(dadosUsuario);
				break;
				
			case REMOVER_USUARIO:
				removerUsuario(dadosUsuario);
				break;
				
			case REMOVER_ALUNOS:
				removerTodosAlunos(dadosUsuario);
				break;
				
			case REMOVER_EXERCICIOS:
				removerTodosExercicios(dadosUsuario);
				break;
				
			case REMOVER_SUBMISSOES:
				removerTodasSubmissoes(dadosUsuario);
				break;
				
			case RESETAR_BD:
				resetarBD(dadosUsuario);
				break;

			default:
				System.out.println("NUMERO INVALIDO");
			}

		} while (opcao != SAIR);

	}

	/**
	 * exibe o menu do moderador, com as opcoes disponiveis para este usuario
	 * @param dadosUsuario - lista com os dados do usuario
	 */
	private static void menuModerador(List<String> dadosUsuario) {

		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int TROCAR_SENHA = 2;
		final int VER_USUARIOS = 3;
		final int CRIAR_EXERCICIO = 4;
		final int REMOVER_EXERCICIO = 5;
		final int ATUALIZAR_EXERCICIO = 6;
		final int VER_EXERCICIOS = 7;
		final int VER_CORRECAO = 8;
		final int VER_SUBMISSOES = 9;
		final int CORRIGIR_SUBMISSAO = 10;
		final int CRIAR_ALUNO = 11;
		int opcao = -1;

		do {
			System.out.println(IO.NOVA_LINHA + "Ola, "
					+ dadosUsuario.get(DadosUsuarioEnum.NOME.ordinal())
					+ ", email: "
					+ dadosUsuario.get(DadosUsuarioEnum.EMAIL.ordinal()));
			System.out.println(IO.NOVA_LINHA + "MENU PROFESSOR");
			System.out.println("1 - EDITAR DADOS");
			System.out.println("2 - TROCAR SENHA");
			System.out.println("3 - VER USUARIOS");
			System.out.println("4 - CRIAR EXERCICIO");
			System.out.println("5 - REMOVER EXERCICIO");
			System.out.println("6 - ATUALIZAR EXERCICIO");
			System.out.println("7 - VER EXERCICIOS");
			System.out.println("8 - VER CORRECAO");
			System.out.println("9 - VER SUBMISSOES");
			System.out.println("10 - CORRIGIR SUBMISSAO");
			System.out.println("11 - CRIAR ALUNO");
			System.out.println();
			System.out.println("0 - SAIR");
			System.out.println();
			System.out.print("ESCOLHA O NUMERO DA OPCAO: ");
			opcao = IO.recebeInteiro();
			switch (opcao) {
			case SAIR:
				System.out.print("PRESSIONE ENTER PARA ENCERRAR");
				sc.nextLine();
				break;
			case EDITAR_DADOS:
				editarDados(dadosUsuario);
				break;
			case TROCAR_SENHA:
				mudarSenha(dadosUsuario);
				break;
			case VER_USUARIOS:
				verUsuarios();

				break;
			case CRIAR_ALUNO:
				try {

					criarUsuario(UsuariosEnum.ALUNO);
				} catch (IOException e) {
					System.out.println("Dados Invalidos!");
				}
				break;
			case CRIAR_EXERCICIO:
				try {
					criarExercicio();
				} catch (Exception e) {
					System.out.println("Dados Invalidos!");
				}
				break;

			case REMOVER_EXERCICIO:
				if (removerExercicio())
					System.out.println("Exercicio removido com sucesso!");
				else
					System.out.println("id invalido!");
				break;

			case ATUALIZAR_EXERCICIO:
				try {
					if (atualizarExercicio())
						System.out.println("Exercicio atualizado com sucesso!");
					else
						System.out
								.println("Nao foi possivel atualizar o exercicio!");
				} catch (Exception e) {
					System.out.println("Dados Invalidos!");
				}
				break;

			case VER_EXERCICIOS:
				verExercicios();
				break;
				
			case VER_SUBMISSOES:
				verSubmissoes(dadosUsuario);
				
			case VER_CORRECAO:
				verCorrecao(dadosUsuario);
				break;
			case CORRIGIR_SUBMISSAO:
				corrigirSubmissao(dadosUsuario);
				break;

			default:
				System.out.println("NUMERO INVALIDO");
			}
		} while (opcao != SAIR);

	}

	/**
	 * exibe o menu do aluno, com as opcoes disponiveis para este usuario
	 * @param dadosUsuario - lista com os dados do usuario
	 */
	private static void menuAluno(List<String> dadosUsuario) {

		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int TROCAR_SENHA = 2;
		final int VER_PLANILHA = 3;
		final int VER_EXERCICIOS = 4;
		final int BAIXAR_EXERCICIO = 5;
		final int SUBMETER_EXERCICIO = 6;
		final int VER_CORRECAO = 7;
		final int VER_SUBMISSOES = 8;
		int opcao = -1;

		do {

			System.out.println(IO.NOVA_LINHA + "Ola, "
					+ dadosUsuario.get(DadosUsuarioEnum.NOME.ordinal())
					+ ", email: "
					+ dadosUsuario.get(DadosUsuarioEnum.EMAIL.ordinal()));
			System.out.println(IO.NOVA_LINHA + "MENU PROFESSOR");
			System.out.println("1 - EDITAR DADOS");
			System.out.println("2 - TROCAR SENHA");
			System.out.println("3 - VER PLANILHA");
			System.out.println("4 - VER EXERCICIOS");
			System.out.println("5 - BAIXAR EXERCICIO");
			System.out.println("6 - SUBMETER EXERCICIO");
			System.out.println("7 - VER CORRECAO");
			System.out.println("8 - VER SUBMISSOES");
			System.out.println();
			System.out.println("0 - SAIR");
			System.out.println();
			System.out.print("ESCOLHA O NUMERO DA OPCAO: ");
			opcao = IO.recebeInteiro();

			switch (opcao) {
			case SAIR:
				System.out.print("PRESSIONE ENTER PARA ENCERRAR");
				sc.nextLine();
				break;
			case EDITAR_DADOS:
				editarDados(dadosUsuario);
				break;
			case TROCAR_SENHA:
				mudarSenha(dadosUsuario);
				break;
			case VER_PLANILHA:

				break;
			case VER_EXERCICIOS:
				verExercicios();
				break;
			case BAIXAR_EXERCICIO:
				// TODO sera implementado quando tiver servidor.
				break;
			case SUBMETER_EXERCICIO:
				enviarSubmissao(dadosUsuario);
				break;
				
			case VER_SUBMISSOES:
				verSubmissoes(dadosUsuario);
				break;
				
			case VER_CORRECAO:
				verCorrecao(dadosUsuario);
				break;

			default:
				System.out.println("NUMERO INVALIDO");
			}
		} while (opcao != SAIR);

	}

	/**
	 * exibe os exercicios cadastrados pelo professor ou monitor
	 */
	private static void verExercicios() {
		List<Exercicio> exercicios = Sistema.verExercicios();
		Iterator<Exercicio> it = exercicios.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	/**
	 * atualiza o exercicio desejado
	 * @return true caso consiga atualizar o exercicio, false caso contrario
	 * @throws Exception
	 */
	private static boolean atualizarExercicio() throws Exception {
		int id = Integer.parseInt(IO.recebeDados("ID DO EXERCICIO: "));
		String nome = IO.recebeDados("NOME: ");
		String enunciado = IO.recebeDados("ENUNCIADO: ");
		String dataDeEntrega = IO.recebeDados("DATA DE ENTREGA: ");
		return Sistema.atualizarExercicio(id, nome, enunciado, dataDeEntrega);

	}

	/**
	 * remove o exercicio desejado
	 * @return true caso consiga remover o exercicio
	 */
	private static boolean removerExercicio() {
		int id = Integer.parseInt(IO.recebeDados("ID DO EXERCICIO: "));
		return Sistema.removerExercicio(id);
	}

	/**
	 * Cria um exercicio com nome, enunciado(descricao) e data de entrega
	 * @throws Exception
	 */
	private static void criarExercicio() throws Exception {
		List<String> dadosExercicio = new ArrayList<String>();

		dadosExercicio.add(IO.recebeDados("NOME: "));
		dadosExercicio.add(IO.recebeDados("ENUNCIADO: "));
		dadosExercicio.add(IO.recebeDados("DATA DE ENTREGA: "));

		Sistema.addExercicio(dadosExercicio);
	}
	
	/**
	 * acessa a correcao do exercicio submetido, para ver notas e comentarios
	 * @param dadosUsuario - lista de dados do usuario
	 */
	public static void verCorrecao(List<String> dadosUsuario) {
		int idExercicio = Integer.parseInt(IO.recebeDados("ID DO EXERCICIO: "));
		String correcao = Sistema.getCorrecao(idExercicio, dadosUsuario.get(DadosUsuarioEnum.LOGIN.ordinal()));
		System.out.println(correcao);
		
	}

	/**
	 * acessa os exercicios submetidos pelo aluno
	 * @param dadosUsuario - lista de dados do usuario
	 */
	public static void verSubmissoes(List<String> dadosUsuario) {
		List<Submissao> submissoes = Sistema.getsubmissoes();
		Iterator<Submissao> it = submissoes.iterator();
		while (it.hasNext()) {
			Submissao sub = it.next();
			if (sub.getLogin().equals(dadosUsuario.get(DadosUsuarioEnum.LOGIN.ordinal()))) {
				System.out.println("ID: " + sub.getId() + "| Exercicio: " + sub.getIdExercicio());
			}
		}
		
	}

	/**
	 * imprime os usuarios cadastrados
	 */
	public static void verUsuarios() {
		System.out.println(Sistema.listarUsuarios());
	}

	/**
	 * cria um usuario (aluno ou moderador)
	 * @param tipo - tipo de usuario 
	 * @throws IOException
	 */
	public static void criarUsuario(UsuariosEnum tipo) throws IOException {
		List<String> dadosUsuario = new ArrayList<String>();

		dadosUsuario.add(IO.recebeDados("LOGIN: "));
		dadosUsuario.add(IO.recebeDados("SENHA: "));
		dadosUsuario.add(IO.recebeDados("MATRICULA: "));
		dadosUsuario.add(IO.recebeDados("NOME: "));
		dadosUsuario.add(IO.recebeDados("EMAIL: "));
		dadosUsuario.add(IO.recebeDados("TURMA: "));

		Sistema.addUsuario(dadosUsuario, tipo);
	}

	/**
	 * envia a senha por email. 
	 */
	public static void enviarSenhaPorEmail() {
		String login = IO.recebeDados("LOGIN: ");
		String email = IO.recebeDados("EMAIL: ");
		Sistema.enviaSenhaPorEmail(login, email);
	}

	/**
	 * submete um exercicio para ser corrigido
	 * @param usuario - lista de dados do usuario
	 */
	public static void enviarSubmissao(List<String> usuario) {
		String caminho = IO.recebeDados("CAMINHO: ");
		int idExercicio = Integer.parseInt(IO.recebeDados("ID EXERCICIO: "));
		Sistema.enviarSubmissao(usuario.get(DadosUsuarioEnum.LOGIN.ordinal()), caminho, idExercicio);
	}

		/**
		 * Edita os dados do usuario. 
		 * @param usuario - lista de dados do usuario
		 */
		private static void editarDados(List<String> usuario) {

		System.out.println("EDITAR DADOS DE "
				+ usuario.get(DadosUsuarioEnum.NOME.ordinal()));
		System.out.println("CASO NAO QUEIRA ALTERAR DETERMINADO CAMPO, APENAS PRESSIONE ENTER");
		usuario.set(DadosUsuarioEnum.NOME.ordinal(), IO.recebeDados("NOME: ",
				usuario.get(DadosUsuarioEnum.NOME.ordinal())));
		usuario.set(DadosUsuarioEnum.MATRICULA.ordinal(), IO.recebeDados(
				"MATRICULA: ", usuario
						.get(DadosUsuarioEnum.MATRICULA.ordinal())));
		usuario.set(DadosUsuarioEnum.EMAIL.ordinal(), IO.recebeDados("EMAIL: ",
				usuario.get(DadosUsuarioEnum.EMAIL.ordinal())));

		Sistema.editaDadosUsuario(usuario, tipoUsuario);
	}

	/**
	 * troca a senha do usuario
	 * @param usuario - lista de dados do usuario
	 */
	public static void mudarSenha(List<String> usuario) {

		System.out.println("TROCAR SENHA DE "
				+ usuario.get(DadosUsuarioEnum.NOME.ordinal()));
		String senhaAntiga = IO.recebeDados("SENHA ATUAL: ");

		String novaSenha = IO.recebeDados("NOVA SENHA: ");
		String confirmaNovaSenha = IO.recebeDados("CONFIRME A SENHA: ");
		if (Sistema.mudaSenha(usuario.get(DadosUsuarioEnum.LOGIN.ordinal()),
				senhaAntiga, novaSenha, confirmaNovaSenha)) {
			System.out.println("SENHA ALTERADA COM SUCESSO");
		} else
			System.out.println("A SENHA NAO PODE SER ALTERADA");

	}

	/**
	 * corrige o exercicio submetido pelo aluno
	 * @param usuario - lista de dados do usuario
	 */
	private static void corrigirSubmissao(List<String> usuario) {
		String loginAluno = IO.recebeDados("LOGIN DO ALUNO: ");
		int lab = Integer.parseInt(IO.recebeDados("ID EXERCICIO: "));
		System.out.println("NOTA: ");
		double notaAluno = IO.recebeDouble();
		String comentarioLab = IO.recebeDados("COMENTARIO: ");
		
		if(Sistema.corrigirSubmissao(usuario.get(DadosUsuarioEnum.LOGIN.ordinal()), 
				loginAluno, lab, notaAluno, comentarioLab)){
			System.out.println("OPERACAO REALIZADA COM SUCESSO");
		}else System.out.println("OPERACAO FALHOU");

	}
	
	/**
	 * remove o usuario (escolhido pelo id)
	 * @param usuario - lista de dados do usuario
	 */
	public static void removerUsuario(List<String> usuario) {
		System.out.println("ID DO USUARIO A SER DELETADO: ");
		int idUsuario = IO.recebeInteiro();
		if (Sistema.removerUsuario(usuario.get(DadosUsuarioEnum.LOGIN.ordinal()), idUsuario))
			System.out.println("USUARIO REMOVIDO COM SUCESSO!");
		else System.out.println("NAO FOI POSSIVEL REMOVER O USUARIO!");
	}
	
	/**
	 * remove todos os alunos do bando de dados
	 * @param usuario
	 */
	public static void removerTodosAlunos(List<String> usuario) {
		System.out.println("TODOS OS ALUNOS SERAO APAGADOS DEFINITIVAMENTE DO BANCO DE DADOS!");
		String confirmacao = IO.recebeDados("TEM CERTEZA QUE DESEJA REMOVE-LOS? sim/nao ");
		if (confirmacao.equalsIgnoreCase("sim"))
			Sistema.removerTodosAlunos(usuario.get(DadosUsuarioEnum.LOGIN.ordinal()));
	}
	
	/**
	 * remove todos os exercicios e submissoes correspondentes do banco de dados
	 * @param usuario
	 */
	public static void removerTodosExercicios(List<String> usuario) {
		System.out.println("TODOS OS EXERCICIOS E SUBMISSOES CORRESPONDENTES SERAO APAGADOS DEFINITIVAMENTE DO BANCO DE DADOS!");
		String confirmacao = IO.recebeDados("TEM CERTEZA QUE DESEJA REMOVE-LOS? sim/nao ");
		if (confirmacao.equalsIgnoreCase("sim"))
			Sistema.removerTodosExercicios(usuario.get(DadosUsuarioEnum.LOGIN.ordinal()));
	}
	
	/**
	 * remove todas as submissoes do banco de dados
	 * @param usuario
	 */
	public static void removerTodasSubmissoes(List<String> usuario) {
		System.out.println("TODOS AS SUBMISSOES SERAO APAGADOS DEFINITIVAMENTE DO BANCO DE DADOS!");
		String confirmacao = IO.recebeDados("TEM CERTEZA QUE DESEJA REMOVE-LOS? sim/nao ");
		if (confirmacao.equalsIgnoreCase("sim"))
			Sistema.removerTodasSubmissoes(usuario.get(DadosUsuarioEnum.LOGIN.ordinal()));
	}

	/**
	 * Reseta o banco de dados(apaga os dados dos usuarios, exercicios e submissoes) 
	 * e cria o usuario professor com os dados default
	 * @param usuario - lista de dados do usuario
	 */
	public static void resetarBD(List<String> usuario) {
		System.out.println("TODOS OS DADOS SERAO APAGADOS DEFINITIVAMENTE DO BANCO DE DADOS!");
		String confirmacao = IO.recebeDados("TEM CERTEZA QUE DESEJA RESETAR O BANCO DE DADOS? sim/nao ");
		if (confirmacao.equalsIgnoreCase("sim"))
			Sistema.resetaBD(usuario.get(DadosUsuarioEnum.LOGIN.ordinal()));
	}
}


