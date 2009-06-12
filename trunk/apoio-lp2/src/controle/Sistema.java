package controle;

import graphic.*;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import disciplina.Exercicio;

import users.*;

// nao deu certo implementar SistemaI por causa do static =x
public class Sistema{

	public static void editaDadosUsuario(List<String> dados) {
		// TODO Auto-generated method stub
		
	}

	public static boolean login() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean logoff() throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	public static void mandaBaixar(String caminho) {
		// TODO Auto-generated method stub
	}
	
	public static boolean mandaSenhaPorEmail(String login, String email) {
		Map<String, Usuario> usrs = BD.getUsuarios();
		if (usrs.containsKey(login) && usrs.get(login).getEmail().equalsIgnoreCase(email)) {
			//TODO enviar por email a senha do usuario
			return true;
		} return false;
			
			
	}

	public static boolean subemeterExercicio(String login, Exercicio exercicio) {
		//TODO Colocar data limite de entrega...
		if (BD.getExercicios().contains(exercicio)) {
			String[] sub = Interface.subemeterExercicio();
			//transformar a data em Gregorian Calendar (sub[1])
			Submissao submissao = new Submissao(sub[0], new GregorianCalendar(), sub[2]);
			BD.addSubmissao(submissao);
			return true;
		} return false;
	}

}
