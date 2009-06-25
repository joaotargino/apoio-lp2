package controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import users.Aluno;


/**
 * Infelizmente teremos que usar arquivo por enquanto
 * @author erickson
 *
 */
public class AlunoBD {
	
	private static final String CAMINHO = "./src/dados/alunosBD.txt";

	public static List<Aluno> getAlunos() {
		try {
			List<Aluno> alunos = (List) Serializar.recuperarObjeto(new File(CAMINHO));
			return alunos;
		} catch (Exception e1) {
			return new ArrayList<Aluno>();
		}
//		BufferedReader reader = new BufferedReader( new FileReader(CAMINHO) );
//		String tupla = null;
//		List<Aluno> alunos = new ArrayList<Aluno>();
//		while ((tupla = reader.readLine()) != null) {
//			try {
//				alunos.add(criaAluno(tupla));
//			} catch (Exception e) {
//				continue;
//			}
//		}
//		reader.close();
	}
	
	public static Aluno getAluno(String matricula) {
		List<Aluno> alunos = getAlunos();
		Iterator<Aluno> alIt = alunos.iterator();
		while (alIt.hasNext()) {
			Aluno aluno = alIt.next();
			if (aluno.getMatricula().equals(matricula))
				return aluno;
		}
		return null;
	}
	
	public static boolean cadastraAluno(Aluno aluno) throws IOException {
		List<Aluno> alunos = getAlunos();
		Iterator<Aluno> alIt = alunos.iterator();
		while(alIt.hasNext()) {
			Aluno alAtual = alIt.next();
			if (alAtual.equals(aluno))
				return false;
		}
		alunos.add(aluno);
		Serializar.salvarObjeto(new File(CAMINHO), alunos);
		return true;
//		FileWriter fw = new FileWriter("./src/controle/alunosBD.txt", true);
//		String dadosAluno = aluno.getMatricula() + SEPARADOR + aluno.getNome() +
//		SEPARADOR + aluno.getEnunciado() + SEPARADOR + aluno.getData() +
//		SEPARADOR + aluno.getDataEntrega();
//		fw.write(FIM_DE_LINHA + dadosAluno);
//		fw.close();
//		return false;
	}
	
	public static boolean removeAluno(String matricula) {
		List<Aluno> alunos = getAlunos();
		Iterator<Aluno> alIt = alunos.iterator();
		while(alIt.hasNext()) {
			Aluno alAtual = alIt.next();
			if (alAtual.getMatricula().equals(matricula)) {
				alunos.remove(alAtual);
				try {
					Serializar.salvarObjeto(new File(CAMINHO), alunos);
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
	
	public static boolean atualizaAluno(Aluno aluno) {
		List<Aluno> alunos = getAlunos();
		Iterator<Aluno> alIt = alunos.iterator();
		while(alIt.hasNext()) {
			Aluno alAtual = alIt.next();
			if (alAtual.equals(aluno)) {
				int indice = alunos.indexOf(alAtual);
				alunos.remove(alAtual);
				alunos.add(indice, aluno);
				try {
					Serializar.salvarObjeto(new File(CAMINHO), alunos);
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

//	public static String[] getSubmissao(Aluno aluno) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public static void addAluno(Aluno aluno, String turma) {
//		// TODO Auto-generated method stub
//		
//	}
//	public static void addSubmissao(Submissao submissao) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public static Map<String, Usuario> getUsuarios() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	public static void main(String[] args) {
		try {
			Aluno al1 = new Aluno("AlunoTest", "20821282", "12345", "20821282", "alunotest@email.com", "2009.1");
			Aluno al2 = new Aluno("Erickson", "20821200", "12345", "20821200", "erickson@email.com", "2009.1");
			
			System.out.println("Cadastrando!");
			AlunoBD.cadastraAluno(al1);
			System.out.println(AlunoBD.getAlunos().toString());
			System.out.println("Cadastrando!");
			AlunoBD.cadastraAluno(al2);
			System.out.println(AlunoBD.getAlunos().toString());
		
			System.out.println("Removendo!");
			AlunoBD.removeAluno("20821282");
			System.out.println(AlunoBD.getAlunos().toString());
			System.out.println("Atualizando!");
			al2.setEmail("ericksonfilipe@gmail.com");
			System.out.println("Atualizou? " + AlunoBD.atualizaAluno(al2));
			System.out.println(AlunoBD.getAlunos().toString());
		} catch (IOException e) {
			System.out.print(e.getMessage());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
