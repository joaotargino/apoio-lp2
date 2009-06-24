package controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import disciplina.Exercicio;


/**
 * Infelizmente teremos que usar arquivo por enquanto
 * @author erickson
 *
 */
public class ExercicioBD {
	private static final String SEPARADOR = ":.:"; 
	private static final String FIM_DE_LINHA = System.getProperty("line.separator");
	private static final String CAMINHO = "./src/controle/exerciciosBD.txt";

	public static List<Exercicio> getExercicios() throws IOException {
		try {
			List<Exercicio> exercicios = (List) Serializar.recuperarObjeto(new File(CAMINHO));
			return exercicios;
		} catch (Exception e1) {
			return new ArrayList<Exercicio>();
		}
//		BufferedReader reader = new BufferedReader( new FileReader(CAMINHO) );
//		String tupla = null;
//		List<Exercicio> exercicios = new ArrayList<Exercicio>();
//		while ((tupla = reader.readLine()) != null) {
//			try {
//				exercicios.add(criaExercicio(tupla));
//			} catch (Exception e) {
//				continue;
//			}
//		}
//		reader.close();
	}
	
	public static Exercicio getExercicio(int id) throws IOException {
		List<Exercicio> exercicios = getExercicios();
		Iterator<Exercicio> exs = exercicios.iterator();
		while (exs.hasNext()) {
			Exercicio exercicio = exs.next();
			if (exercicio.getId() == id)
				return exercicio;
		}
		return null;
	}
	
	public static boolean cadastraExercicio(Exercicio exercicio) throws IOException {
		List<Exercicio> exercicios = getExercicios();
		System.out.println(exercicios);
		exercicios.add(exercicio);
		Serializar.salvarObjeto(new File(CAMINHO), exercicios);
		return true;
//		FileWriter fw = new FileWriter("./src/controle/exerciciosBD.txt", true);
//		String dadosExercicio = exercicio.getId() + SEPARADOR + exercicio.getNome() +
//		SEPARADOR + exercicio.getEnunciado() + SEPARADOR + exercicio.getData() +
//		SEPARADOR + exercicio.getDataEntrega();
//		fw.write(FIM_DE_LINHA + dadosExercicio);
//		fw.close();
//		return false;
	}
	
	private static Exercicio criaExercicio(String dados) throws Exception {
		String[] tupla = dados.split(SEPARADOR);
		int id = Integer.parseInt(tupla[0]);
		String nome = tupla[1];
		String enunciado = tupla[2];
		Calendar data = criaCalendario(tupla[3]);
		Calendar dataEntrega = criaCalendario(tupla[4]);
		return new Exercicio(id, nome, enunciado, data, dataEntrega);
	}
	
	private static Calendar criaCalendario(String cal) {
		String[] date = cal.split("/");
		return new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
	}

//	public static String[] getSubmissao(Exercicio exercicio) {
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
			ExercicioBD.cadastraExercicio(new Exercicio(1,"name", "enunciadoteste", new GregorianCalendar(), new GregorianCalendar()));
			Iterator<Exercicio> ex = ExercicioBD.getExercicios().iterator();
			while(ex.hasNext()) {
				System.out.println(ex.next().getNome());
			}
			
			ExercicioBD.cadastraExercicio(new Exercicio(2,"outro", "enunciadoteste", new GregorianCalendar(), new GregorianCalendar()));
			ex = ExercicioBD.getExercicios().iterator();
			while(ex.hasNext()) {
				System.out.println(ex.next().getNome());
			}
		} catch (IOException e) {
			System.out.print(e.getMessage());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
