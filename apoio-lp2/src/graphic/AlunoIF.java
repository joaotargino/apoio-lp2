package graphic;

import java.util.Iterator;
import java.util.List;

import controle.DadosUsuarioEnum;
import controle.Sistema;
import controle.Submissao;

public class AlunoIF extends UsuarioIF{

	@Override
	public void telaInicial(List<String> dadosUsuario) {
		System.out.println(dadosUsuario.get(1));
		final int SAIR = 0;
		final int EDITAR_DADOS = 1;
		final int TROCAR_SENHA = 2;
		final int VER_PLANILHA = 3;
		final int VER_EXERCICIO = 4;
		final int BAIXAR_EXERCICIO = 5;
		final int SUBMETER_EXERCICIO = 6;
		final int VER_CORRECAO = 7;
		final int VER_SUBMISSOES = 8;
		int opcao = -1;
	
		do {
	
			System.out.println(IO.NOVA_LINHA + "Olá, "
					+ dadosUsuario.get(DadosUsuarioEnum.NOME.ordinal())
					+ ", email: "
					+ dadosUsuario.get(DadosUsuarioEnum.EMAIL.ordinal()));
			System.out.println(IO.NOVA_LINHA + "MENU ALUNO");
			System.out.println("1 - EDITAR DADOS");
			System.out.println("2 - TROCAR SENHA");
			System.out.println("3 - VER PLANILHA DE NOTAS");
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
				IO.scan.nextLine();
				break;
			case EDITAR_DADOS:
				editarDados(dadosUsuario);
				break;
			case TROCAR_SENHA:
				mudarSenha(dadosUsuario);
				break;
			case VER_PLANILHA:
				break;
			case VER_EXERCICIO:
				verExercicios();
				break;
			case BAIXAR_EXERCICIO:
				// TODO Sistema.mandaBaixar(caminho); // implementa, po!
				break;
			case SUBMETER_EXERCICIO:
				// TODO Sistema.subemeterExercicio(dadosUsuario
				// .get(DadosUsuarioEnum.LOGIN.ordinal()), "o caminho",
				// "id ex");
				break;
				
			case VER_CORRECAO:
				verCorrecao();
				break;
				
			case VER_SUBMISSOES:
				verSubmissoes();
				break;
	
			default:
				System.out.println("NUMERO INVALIDO");
			}
		} while (opcao != SAIR);
		
	}

	@Override
	public void verCorrecao() {
		int idExercicio = Integer.parseInt(IO.recebeDados("ID DO EXERCICIO: "));
		String correcao = Sistema.getCorrecao(idExercicio, getLogin());
		System.out.println(correcao);
		
	}

	@Override
	public void verSubmissoes() {
		List<Submissao> submissoes = Sistema.getsubmissoes();
		Iterator<Submissao> it = submissoes.iterator();
		while (it.hasNext()) {
			Submissao sub = it.next();
			if (sub.getLogin().equals(getLogin())) {
				System.out.println("ID: " + sub.getId() + "| Exercicio: " + sub.getIdExercicio());
			}
		}
		
	}

}
