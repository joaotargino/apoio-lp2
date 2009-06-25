package controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import disciplina.Exercicio;

import users.*;


/**
 * Infelizmente teremos que usar arquivo por enquanto
 * @author erickson
 *
 */
public class BD {
	
	//mudar para usuariosBD.txt
	private static final File USUARIOSBD = new File("./src/dados/usuariosBD.txt");
	private static final File SUBMISSOESBD = new File("./src/dados/submissoesBD.txt");
	private static final File EXERCICIOSBD = new File("./src/dados/exerciciosBD.txt");

	public static List<Usuario> getUsuarios() {
		try {
			List<Usuario> users = (List) Serializar.recuperarObjeto(USUARIOSBD);
			return users;
		} catch (Exception e1) {
			return new ArrayList<Usuario>();
		}
	}
	
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
	
	public static Usuario getUsuario(String login) {
		List<Usuario> users = getUsuarios();
		Iterator<Usuario> it = users.iterator();
		while (it.hasNext()) {
			Usuario u = it.next();
			if (u.getLogin().equals(login))
				return u;
		}
		return null;
	}
	
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
	 * Cadastra qualquer tipo de usuario
	 * @param u
	 * @return
	 * @throws IOException
	 */
	public static boolean cadastraUsuario(Usuario u) throws IOException {
		List<Usuario> users = getUsuarios();
		Iterator<Usuario> it = users.iterator();
		while(it.hasNext()) {
			Usuario user = it.next();
			if (user.equals(u))
				return false;
		}
		users.add(u);
		Serializar.salvarObjeto(USUARIOSBD, users);
		return true;
	}
	
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	
	public static boolean atualizaUsuario(Usuario u) {
		List<Usuario> users = getUsuarios();
		Iterator<Usuario> it = users.iterator();
		while(it.hasNext()) {
			Usuario user = it.next();
			if (user.equals(u)) {
				int indice = users.indexOf(user);
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
	
	public static List<Exercicio> getExercicios() {
		try {
			List<Exercicio> exercicios = (List) Serializar.recuperarObjeto(EXERCICIOSBD);
			return exercicios;
		} catch (Exception e1) {
			return new ArrayList<Exercicio>();
		}
	}
	
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
	
	public static boolean cadastraExercicio(Exercicio exercicio) throws IOException {
		List<Exercicio> exercicios = getExercicios();
		Iterator<Exercicio> exIt = exercicios.iterator();
		while(exIt.hasNext()) {
			Exercicio exAtual = exIt.next();
			if (exAtual.equals(exercicio))
				return false;
		}
		exercicios.add(exercicio);
		Serializar.salvarObjeto(EXERCICIOSBD, exercicios);
		return true;
	}
	
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	
	public static boolean atualizaExercicio(int id, Exercicio exercicio) {
		List<Exercicio> exercicios = getExercicios();
		Iterator<Exercicio> exIt = exercicios.iterator();
		while(exIt.hasNext()) {
			Exercicio exAtual = exIt.next();
			if (exAtual.getId() == id) {
				int indice = exercicios.indexOf(exAtual);
				exercicios.remove(exAtual);
				exercicio.setId(id);
				exercicios.add(indice, exercicio);
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
	
	public static List<Submissao> getSubmissoes() {
		try {
			List<Submissao> submissoes = (List) Serializar.recuperarObjeto(SUBMISSOESBD);
			return submissoes;
		} catch (Exception e1) {
			return new ArrayList<Submissao>();
		}
	}
	
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}
	
	public static boolean atualizaSubmissao(Submissao sub) {
		List<Submissao> submissoes = getSubmissoes();
		Iterator<Submissao> it = submissoes.iterator();
		while(it.hasNext()) {
			Submissao atual = it.next();
			if (atual.equals(sub)) {
				int indice = submissoes.indexOf(atual);
				submissoes.remove(atual);
				submissoes.add(indice, sub);
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
	
//	private static Aluno criaAluno(String dados) throws Exception {
//		String[] tupla = dados.split(SEPARADOR);
//		int id = Integer.parseInt(tupla[0]);
//		String nome = tupla[1];
//		String enunciado = tupla[2];
//		Calendar data = criaCalendario(tupla[3]);
//		Calendar dataEntrega = criaCalendario(tupla[4]);
//		return new Aluno(id, nome, enunciado, data, dataEntrega);
//	}
//	
//	private static Calendar criaCalendario(String cal) {
//		String[] date = cal.split("/");
//		return new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
//	}

	
	public static void main(String[] args) {
		try {
			Aluno al1 = new Aluno("AlunoTest", "20821282", "12345", "20821282", "alunotest@email.com", "2009.1");
			Aluno al2 = new Aluno("Erickson", "20821200", "12345", "20821200", "erickson@email.com", "2009.1");
			
			System.out.println("Cadastrando!");
			BD.cadastraUsuario(al1);
			System.out.println(BD.getAlunos().toString());
			System.out.println("Cadastrando!");
			BD.cadastraUsuario(al2);
			System.out.println(BD.getAlunos().toString());
		
			System.out.println("Removendo!");
			BD.removeUsuario("20821282");
			System.out.println(BD.getAlunos().toString());
			System.out.println("Atualizando!");
			al2.setEmail("ericksonfilipe@gmail.com");
			System.out.println("Atualizou? " + BD.atualizaUsuario(al2));
			System.out.println(BD.getAlunos().toString());
		} catch (IOException e) {
			System.out.print(e.getMessage());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Exercicio ex1 = new Exercicio(1,"name", "enunciadoteste", new GregorianCalendar(), new GregorianCalendar());
			Exercicio ex2 = new Exercicio(2,"name2", "enunciadoteste2", new GregorianCalendar(), new GregorianCalendar());
			Exercicio ex3 = new Exercicio(3,"name3", "enunciadoteste3", new GregorianCalendar(), new GregorianCalendar());
			Exercicio ex4 = new Exercicio(4,"name", "enunciadoteste4", new GregorianCalendar(), new GregorianCalendar());
			
			System.out.println("Cadastrando!");
			BD.cadastraExercicio(ex1);
			System.out.println(BD.getExercicios().toString());
			System.out.println("Cadastrando!");
			BD.cadastraExercicio(ex2);
			System.out.println(BD.getExercicios().toString());
		
			System.out.println("Removendo!");
			BD.removeExercicio(2);
			System.out.println(BD.getExercicios().toString());
			System.out.println("Atualizando!");
			System.out.println("Atualizou? " + BD.atualizaExercicio(1, ex3));
			System.out.println(BD.getExercicios().toString());
		} catch (IOException e) {
			System.out.print(e.getMessage());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Submissao sub1 = new Submissao("20821200", new GregorianCalendar(), "caminho/do/arquivo.py");
			Submissao sub2 = new Submissao("20821202", new GregorianCalendar(), "caminho/do/arquivo2.py");
			
			System.out.println("Cadastrando!");
			BD.cadastraSubmissao(sub1);
			System.out.println(BD.getSubmissoes().toString());
			System.out.println("Cadastrando!");
			BD.cadastraSubmissao(sub2);
			System.out.println(BD.getSubmissoes().toString());
		
			System.out.println("Removendo!");
			BD.removeSubmissao(1);
			System.out.println(BD.getSubmissoes().toString());
			System.out.println("Atualizando!");
			sub2.setComentario("SAi dai Seu Jegue!");
			System.out.println("Atualizou? " + BD.atualizaSubmissao(sub2));
			System.out.println(BD.getSubmissoes().toString());
		} catch (IOException e) {
			System.out.print(e.getMessage());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
