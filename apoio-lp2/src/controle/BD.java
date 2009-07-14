
package controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import disciplina.Exercicio;
import users.*;


/**
 * Classe responsavel pela manipulação com o banco de dados
 * @author Arnett, Erickson, Jessica e Joao
 * @version 1.0 25 de junho de 2009
 */
public class BD {
	
	//arquivo com o BD dos usuarios
	private static final File USUARIOSBD = new File("./src/dados/usuariosBD.txt");
	//arquivo com o BD das submissoes
	private static final File SUBMISSOESBD = new File("./src/dados/submissoesBD.txt");
	//arquivo com o BD dos exercicios
	private static final File EXERCICIOSBD = new File("./src/dados/exerciciosBD.txt");
	private static final File PAINELBD = new File("./src/dados/PainelBD.txt");

	/**
	 * Retorna uma lista de usuarios cadastrados no banco de dados
	 * @return List<Usuario>
	 * 						lista de usuarios cadastrados no BD
	 */
	public static List<Usuario> getUsuarios() {
		try {
			List<Usuario> users = (List) Serializar.recuperarObjeto(USUARIOSBD);
			return users;
		} catch (Exception e1) {
			return new ArrayList<Usuario>();
		}
	}
	
	/**
	 * Retorna uma lista de alunos cadastrados no banco de dados
	 * @return List<Usuario>
	 * 						lista de alunos cadastrados no BD
	 */
	public static List<Usuario> getAlunos() {
		List<Usuario> users = getUsuarios();
		List<Usuario> alunos = new ArrayList<Usuario>();
		Iterator<Usuario> it = users.iterator();
		while (it.hasNext()) {
			Usuario u = (Usuario) it.next();
			if(u instanceof Aluno)
				alunos.add(u);
		}
		return alunos;
	}

    
	
	/**
	 * Retorna uma lista de moderadores cadastrados no banco de dados
	 * @return List<Usuario>
	 * 						lista de moderadores cadastrados no BD
	 */
	public static List<Usuario> getModeradores() {
		List<Usuario> users = getUsuarios();
		List<Usuario> moderadores = new ArrayList<Usuario>();
		Iterator<Usuario> it = users.iterator();
		while (it.hasNext()) {
			Usuario u = (Usuario) it.next();
			if(u instanceof Moderador)
				moderadores.add(u);
		}
		return moderadores;
	}
	
	/**
	 * Retorna um usuario cadastrado no banco de dados, cujo login eh passado como parametro
	 * @param login
	 * @return Um usuario cujo login eh passado como parametro, e null caso o usuario nao seja encontrado
	 */
	public static Usuario getUsuario(String login) {
		List<Usuario> users = getUsuarios();
		Iterator<Usuario> it = users.iterator();
		while (it.hasNext()) {
			Usuario usr = it.next();
			if (usr.getLogin().equals(login))
				return usr;
		}
		return null;
	}
	
	/**
	 * Retorna um usuario cadastrado no banco de dados, cujo id eh passado como parametro
	 * @param id
	 * @return Um usuario cujo id eh passado como parametro, e null caso o usuario nao seja encontrado
	 */
	public static Usuario getUsuario(int id) {
		List<Usuario> users = getUsuarios();
		Iterator<Usuario> it = users.iterator();
		while (it.hasNext()) {
			Usuario u = it.next();
			if (u.getId() == id)
				return u;
		}
		return null;
	}
	/**
	 * Cadastra qualquer tipo de usuario no banco de dados.
	 * @param u
	 * @return true se o cadastro for efetuado com sucesso, false caso contrario.
	 * @throws IOException
	 */
	public static boolean cadastraUsuario(Usuario u) throws IOException {
		if (u == null)
			return false;
		List<Usuario> users = getUsuarios();
		Iterator<Usuario> it = users.iterator();
		while(it.hasNext()) {
			Usuario user = it.next();
			if (user.equals(u)) {
				return false;
			}
		}
		users.add(u);
		Serializar.salvarObjeto(USUARIOSBD, users);
		return true;
	}
	
	/**
	 * Remove o usuário, cujo login eh igual ao passado como parametro, se possivel.
	 * @param login
	 * @return true, se for possivel remover o usuario, e false caso contrario.
	 */
	public static boolean removeUsuario(String login) {
		List<Usuario> users = getUsuarios();
		Iterator<Usuario> it = users.iterator();
		while(it.hasNext()) {
			Usuario user = it.next();
			if (user.getLogin().equals(login)) {
				users.remove(user);
				try {
					Serializar.salvarObjeto(USUARIOSBD, users);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Remove o usuário, cujo id eh igual ao passado como parametro, se possivel.
	 * @param id
	 * @return true, se for possivel remover o usuario, e false caso contrario.
	 */
	public static boolean removeUsuario(int id) {
		List<Usuario> users = getUsuarios();
		Iterator<Usuario> it = users.iterator();
		while(it.hasNext()) {
			Usuario user = it.next();
			if (user.getId() == id) {
				users.remove(user);
				try {
					Serializar.salvarObjeto(USUARIOSBD, users);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Atualiza um usuario cadastrado no banco de dados
	 * @param u
	 * @return true, se for possivel atualizar o usuario, e false caso contrario.
	 */
	public static boolean atualizaUsuario(Usuario u) {
		List<Usuario> users = getUsuarios();
		Iterator<Usuario> it = users.iterator();
		while(it.hasNext()) {
			Usuario user = it.next();
			if (user.equals(u)) {
				int indice = users.indexOf(user);
				u.setId(user.getId());
				users.remove(user);
				users.add(indice, u);
				try {
					Serializar.salvarObjeto(USUARIOSBD, users);
					return true;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}


	/**
	 * Retorna uma lista de exercicios cadastrados no banco de dados
	 * @return List<Exercicio>
	 * 						lista de exercicios cadastrados no BD
	 */
	public static List<Exercicio> getExercicios() {
		try {
			List<Exercicio> exercicios = (List) Serializar.recuperarObjeto(EXERCICIOSBD);
			return exercicios;
		} catch (Exception e1) {
			return new ArrayList<Exercicio>();
		}
	}
	
	/**
	 * Retorna o exercicio, cujo id eh passado como parametro
	 * @return Exercicio
	 * 						exercicio, cujo id eh passado como parâmetro. ou null, caso contrario.
	 */
	public static Exercicio getExercicio(int id) {
		List<Exercicio> exercicios = getExercicios();
		Iterator<Exercicio> exs = exercicios.iterator();
		while (exs.hasNext()) {
			Exercicio exercicio = exs.next();
			if (exercicio.getId() == id)
				return exercicio;
		}
		return null;
	}
	
	/**
	 * Retorna o exercicio, no BD, cujo nome eh passado como parâmetro
	 * @param nome
	 * @return o exercicio
	 */
	public static Exercicio getExercicio(String nome) {
		List<Exercicio> exercicios = getExercicios();
		Iterator<Exercicio> exs = exercicios.iterator();
		while (exs.hasNext()) {
			Exercicio exercicio = exs.next();
			if (exercicio.getNome().equals(nome))
				return exercicio;
		}
		return null;
	}
	
	/**
	 * cadastra um exercicio no banco de dados.
	 * @param exercicio
	 * @return true se foi possivel cadastrar um exercicio
	 * @throws IOException
	 */
	public static boolean cadastraExercicio(Exercicio exercicio) throws IOException {
		List<Exercicio> exercicios = getExercicios();
		Iterator<Exercicio> it = exercicios.iterator();
		while(it.hasNext()) {
			Exercicio exAtual = it.next();
			if (exAtual.equals(exercicio))
				return false;
		}
		exercicios.add(exercicio);
		Serializar.salvarObjeto(EXERCICIOSBD, exercicios);
		return true;
	}
	
	/**
	 * remove um exercicio do banco de dados;
	 * @param id
	 * @return true se foi possivel remover, e false caso contrario
	 */
	public static boolean removeExercicio(int id) {
		List<Exercicio> exercicios = getExercicios();
		Iterator<Exercicio> exIt = exercicios.iterator();
		while(exIt.hasNext()) {
			Exercicio exAtual = exIt.next();
			if (exAtual.getId() == id) {
				exercicios.remove(exAtual);
				try {
					Serializar.salvarObjeto(EXERCICIOSBD, exercicios);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * atualiza os dados de um exercicio
	 * @param id
	 * @param exercicio
	 * @return true se o exercicio foi atualizado e false caso contrario.
	 */
	public static boolean atualizaExercicio(int id, Exercicio exercicio) {
		List<Exercicio> exercicios = getExercicios();
		Iterator<Exercicio> exIt = exercicios.iterator();
		while(exIt.hasNext()) {
			Exercicio exAtual = exIt.next();
			if (exAtual.getId() == id) {
				try {
					exercicios.get(exercicios.indexOf(exAtual)).setNome(exercicio.getNome());
					exercicios.get(exercicios.indexOf(exAtual)).setDescricao(exercicio.getDescricao());
					exercicios.get(exercicios.indexOf(exAtual)).setDataEntrega(exercicio.getDataEntrega());
				} catch(Exception e) {
					e.printStackTrace();
				}
				try {
					Serializar.salvarObjeto(EXERCICIOSBD, exercicios);
					return true;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	/**
	 * retorna todas as submissos cadastradas no banco de dados.
	 * @return List<Submissao> das submissoes cadastradas no bd
	 */
	public static List<Submissao> getSubmissoes() {
		try {
			List<Submissao> submissoes = (List) Serializar.recuperarObjeto(SUBMISSOESBD);
			return submissoes;
		} catch (Exception e1) {
			return new ArrayList<Submissao>();
		}
	}
	
	/**
	 * retorna uma submissao, cujo id eh igual ao passado como parametro, do banco de dados.
	 * @param id
	 * @return Submissao
	 */
	public static Submissao getSubmissao(int id) {
		List<Submissao> submissoes = getSubmissoes();
		Iterator<Submissao> it = submissoes.iterator();
		while (it.hasNext()) {
			Submissao sub = it.next();
			if (sub.getId() == id)
				return sub;
		}
		return null;
	}
	
	/**
	 * Cadastra uma submissao
	 * @param Submissao
	 * @return true se a submissao for cadastrada com sucesso
	 * @throws IOException
	 */
	public static boolean cadastraSubmissao(Submissao Submissao) throws IOException {
		List<Submissao> submissoes = getSubmissoes();
		Iterator<Submissao> it = submissoes.iterator();
		while(it.hasNext()) {
			Submissao atual = it.next();
			if (atual.equals(Submissao))
				return false;
		}
		submissoes.add(Submissao);
		Serializar.salvarObjeto(SUBMISSOESBD, submissoes);
		return true;
	}
	
	/**
	 * remove uma submissao, cujo id eh igual ao passado como parametro,
	 * se possivel, do banco de dados
	 * @param id
	 * @return true se foi possivel remover
	 */
	public static boolean removeSubmissao(int id) {
		List<Submissao> submissoes = getSubmissoes();
		Iterator<Submissao> it = submissoes.iterator();
		while(it.hasNext()) {
			Submissao atual = it.next();
			if (atual.getId() == id) {
				submissoes.remove(atual);
				try {
					Serializar.salvarObjeto(SUBMISSOESBD, submissoes);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * atualiza uma submissao no banco de dados
	 * @param sub
	 * @return true se foi possivel atualizar
	 */
	public static boolean atualizaSubmissao(int id, Submissao sub) {
		List<Submissao> submissoes = getSubmissoes();
		Iterator<Submissao> it = submissoes.iterator();
		while(it.hasNext()) {
			Submissao atual = it.next();
			if (atual.getId() == id) {
				submissoes.get(submissoes.indexOf(atual)).setCaminho(sub.getCaminho());
                                submissoes.get(submissoes.indexOf(atual)).setComentario(sub.getComentario());
                                submissoes.get(submissoes.indexOf(atual)).setNota(sub.getNota());
				try {
					Serializar.salvarObjeto(SUBMISSOESBD, submissoes);
					return true;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
    @SuppressWarnings("unchecked")
	public static String[]  quadroDeInformacoes() {
    	try {
			String[] informacoes = (String[]) Serializar.recuperarObjeto(PAINELBD);
			return informacoes;
		} catch (Exception e) {
		}
        String[] informacoes  = {"","","",""};
		return informacoes;
    }
    
    public static void gravaInformacoesPainel(String[] lista) {
    	try {
    		PAINELBD.delete();
			Serializar.salvarObjeto(PAINELBD, lista);
		} catch (Exception e) {
		}	
    }
	
	/**
	 * Reseta o banco de dados.
	 */
	public static void reset() {
		USUARIOSBD.delete();
		EXERCICIOSBD.delete();
		SUBMISSOESBD.delete();
	}
	
	/**
	 * Reseta a base de dados de exercicios.
	 */
	public static void resetExercicios() {
		EXERCICIOSBD.delete();
	}
	
	/**
	 * Reseta a base de dados de submissoes.
	 */
	public static void resetSubmissoes() {
		SUBMISSOESBD.delete();
	}
	
	/**
	 * remove os alunos da base de dados de usuarios
	 */
	public static void resetAlunos() {
		List<Usuario> users = BD.getUsuarios();
		users.removeAll(BD.getAlunos());
		try {
			Serializar.salvarObjeto(USUARIOSBD, users);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * remove os moderadores da base de dados de usuarios
	 */
	public static void resetModeradores() {
		List<Usuario> users = BD.getUsuarios();
		users.removeAll(BD.getModeradores());
		try {
			Serializar.salvarObjeto(USUARIOSBD, users);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
