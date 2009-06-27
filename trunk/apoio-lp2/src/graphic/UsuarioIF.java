/**
 * 
 */
package graphic;

import java.util.Iterator;
import java.util.List;

import controle.DadosUsuarioEnum;
import controle.Sistema;
import controle.UsuariosEnum;
import disciplina.Exercicio;

/**
 * @author erickson
 *
 */
public abstract class UsuarioIF {
	private UsuariosEnum tipoUsuario;
	private String login, senha;
	
	/**
	 * @return the tipoUsuario
	 */
	public UsuariosEnum getTipoUsuario() {
		return tipoUsuario;
	}


	/**
	 * @param tipoUsuario the tipoUsuario to set
	 */
	public void setTipoUsuario(UsuariosEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 * @return the senha
	 */
	public String getSenha() {
		return senha;
	}


	/**
	 * @param senha the senha to set
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}


	public void logar() {
		System.out.println("BEM VINDO AO SISTEMA");
		System.out.print("LOGIN: ");
		login = IO.scan.nextLine();
		System.out.print("SENHA: ");
		senha = IO.scan.nextLine();
		tipoUsuario = Sistema.confereLoginSenha(login, senha);
		if (tipoUsuario != UsuariosEnum.INEXISTENTE) {
			telaInicial(Sistema.dadosUsuario(login));
		} else {
			System.out.println("DADOS INCORRETOS");
			logar();
		}
	}


	public abstract void telaInicial(List<String> dadosUsuario);
	
	public void verExercicios() {
		List<Exercicio> exercicios = Sistema.verExercicios();
		Iterator<Exercicio> it = exercicios.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	public void editarDados(List<String> usuario) {

		System.out.println("EDITAR DADOS DE "
				+ usuario.get(DadosUsuarioEnum.NOME.ordinal()));
		usuario.set(DadosUsuarioEnum.NOME.ordinal(), IO.recebeDados("NOME: ",
				usuario.get(DadosUsuarioEnum.NOME.ordinal())));
		usuario.set(DadosUsuarioEnum.MATRICULA.ordinal(), IO.recebeDados(
				"MATRICULA: ", usuario
						.get(DadosUsuarioEnum.MATRICULA.ordinal())));
		usuario.set(DadosUsuarioEnum.EMAIL.ordinal(), IO.recebeDados("EMAIL: ",
				usuario.get(DadosUsuarioEnum.EMAIL.ordinal())));

		Sistema.editaDadosUsuario(usuario, tipoUsuario);
	}

	public void mudarSenha(List<String> usuario) {
		// login, senha antiga, nova senha , confirma senha
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
	
	public void enviaSenhaPorEmail(){
		
	}
	
	public void submeterResposta() {
		String login = IO.recebeDados("LOGIN: ");
		String caminho = IO.recebeDados("CAMINHO: ");
		int idExercicio = Integer.parseInt(IO.recebeDados("ID EXERCICIO: "));
		Sistema.enviarSubmissao(login, caminho, idExercicio);
	}
	
	public abstract void verSubmissoes();
	
	public abstract void verCorrecao();

}
