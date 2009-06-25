package controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import users.Moderador;


/**
 * Infelizmente teremos que usar arquivo por enquanto
 * @author erickson
 *
 */
public class ModeradorBD {
	
	private static final String CAMINHO = "./src/dados/moderadoresBD.txt";

	public static List<Moderador> getModeradores() {
		try {
			List<Moderador> moderadores = (List) Serializar.recuperarObjeto(new File(CAMINHO));
			return moderadores;
		} catch (Exception e1) {
			return new ArrayList<Moderador>();
		}
//		BufferedReader reader = new BufferedReader( new FileReader(CAMINHO) );
//		String tupla = null;
//		List<Moderador> Moderadors = new ArrayList<Moderador>();
//		while ((tupla = reader.readLine()) != null) {
//			try {
//				Moderadors.add(criaModerador(tupla));
//			} catch (Exception e) {
//				continue;
//			}
//		}
//		reader.close();
	}
	
	public static Moderador getModerador(String matricula) {
		List<Moderador> moderadores = getModeradores();
		Iterator<Moderador> it = moderadores.iterator();
		while (it.hasNext()) {
			Moderador moderador = it.next();
			if (moderador.getMatricula().equals(matricula))
				return moderador;
		}
		return null;
	}
	
	public static boolean cadastraModerador(Moderador Moderador) throws IOException {
		List<Moderador> moderadores = getModeradores();
		Iterator<Moderador> it = moderadores.iterator();
		while(it.hasNext()) {
			Moderador atual = it.next();
			if (atual.equals(Moderador))
				return false;
		}
		moderadores.add(Moderador);
		Serializar.salvarObjeto(new File(CAMINHO), moderadores);
		return true;
//		FileWriter fw = new FileWriter("./src/controle/ModeradorsBD.txt", true);
//		String dadosModerador = Moderador.getMatricula() + SEPARADOR + Moderador.getNome() +
//		SEPARADOR + Moderador.getEnunciado() + SEPARADOR + Moderador.getData() +
//		SEPARADOR + Moderador.getDataEntrega();
//		fw.write(FIM_DE_LINHA + dadosModerador);
//		fw.close();
//		return false;
	}
	
	public static boolean removeModerador(String matricula) {
		List<Moderador> moderadores = getModeradores();
		Iterator<Moderador> it = moderadores.iterator();
		while(it.hasNext()) {
			Moderador atual = it.next();
			if (atual.getMatricula().equals(matricula)) {
				moderadores.remove(atual);
				try {
					Serializar.salvarObjeto(new File(CAMINHO), moderadores);
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
	
	public static boolean atualizaModerador(Moderador moderador) {
		List<Moderador> moderadores = getModeradores();
		Iterator<Moderador> it = moderadores.iterator();
		while(it.hasNext()) {
			Moderador atual = it.next();
			if (atual.equals(moderador)) {
				int indice = moderadores.indexOf(atual);
				moderadores.remove(atual);
				moderadores.add(indice, moderador);
				try {
					Serializar.salvarObjeto(new File(CAMINHO), moderadores);
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
	
//	private static Moderador criaModerador(String dados) throws Exception {
//		String[] tupla = dados.split(SEPARADOR);
//		int id = Integer.parseInt(tupla[0]);
//		String nome = tupla[1];
//		String enunciado = tupla[2];
//		Calendar data = criaCalendario(tupla[3]);
//		Calendar dataEntrega = criaCalendario(tupla[4]);
//		return new Moderador(id, nome, enunciado, data, dataEntrega);
//	}
//	
//	private static Calendar criaCalendario(String cal) {
//		String[] date = cal.split("/");
//		return new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
//	}

//	public static String[] getSubmissao(Moderador Moderador) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public static void addModerador(Moderador Moderador, String turma) {
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
			Moderador al1 = new Moderador("ModeradorTest", "20821282", "12345", "20821282", "moderadortest@email.com", "2009.1");
			Moderador al2 = new Moderador("Raquel", "20821200", "12345", "20821200", "raquel@email.com", "2009.1");
			
			System.out.println("Cadastrando!");
			ModeradorBD.cadastraModerador(al1);
			System.out.println(ModeradorBD.getModeradores().toString());
			System.out.println("Cadastrando!");
			ModeradorBD.cadastraModerador(al2);
			System.out.println(ModeradorBD.getModeradores().toString());
		
			System.out.println("Removendo!");
			ModeradorBD.removeModerador("20821282");
			System.out.println(ModeradorBD.getModeradores().toString());
			System.out.println("Atualizando!");
			al2.setEmail("raquel@gmail.com");
			System.out.println("Atualizou? " + ModeradorBD.atualizaModerador(al2));
			System.out.println(ModeradorBD.getModeradores().toString());
		} catch (IOException e) {
			System.out.print(e.getMessage());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
