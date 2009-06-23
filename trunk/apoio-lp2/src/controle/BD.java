package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import disciplina.Exercicio;

import users.Aluno;
import users.Usuario;


/**
 * Infelizmente teremos que usar arquivo por enquanto
 * @author erickson
 *
 */
public class BD {

	public static List<Exercicio> getExercicios() throws IOException {
		BufferedReader reader = new BufferedReader( new FileReader("exerciciosBD.txt") );
		String tupla = null;
		List<Exercicio> exercicios = new ArrayList<Exercicio>();
		while ((tupla = reader.readLine()) != null) {
			// TODO criar metodo privado que retorna um exercicio
			exercicios.add(new Exercicio(tupla.split("|")))
		}
		return null;
	}

	public static void addSubmissao(Submissao submissao) {
		// TODO Auto-generated method stub
		
	}

	public static String[] getExercicio(Exercicio exercicio) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String[] getSubmissao(Exercicio exercicio) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void addAluno(Aluno aluno, String turma) {
		// TODO Auto-generated method stub
		
	}

	public static Map<String, Usuario> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
