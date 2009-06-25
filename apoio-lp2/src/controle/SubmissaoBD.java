package controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;


/**
 * Infelizmente teremos que usar arquivo por enquanto
 * @author erickson
 *
 */
public class SubmissaoBD {
	
	private static final String CAMINHO = "./src/dados/submissoesBD.txt";

	public static List<Submissao> getSubmissaoes() {
		try {
			List<Submissao> submissoes = (List) Serializar.recuperarObjeto(new File(CAMINHO));
			return submissoes;
		} catch (Exception e1) {
			return new ArrayList<Submissao>();
		}
//		BufferedReader reader = new BufferedReader( new FileReader(CAMINHO) );
//		String tupla = null;
//		List<Submissao> Submissaos = new ArrayList<Submissao>();
//		while ((tupla = reader.readLine()) != null) {
//			try {
//				Submissaos.add(criaSubmissao(tupla));
//			} catch (Exception e) {
//				continue;
//			}
//		}
//		reader.close();
	}
	
	public static Submissao getSubmissao(int id) {
		List<Submissao> submissoes = getSubmissaoes();
		Iterator<Submissao> it = submissoes.iterator();
		while (it.hasNext()) {
			Submissao sub = it.next();
			if (sub.getId() == id)
				return sub;
		}
		return null;
	}
	
	public static boolean cadastraSubmissao(Submissao Submissao) throws IOException {
		List<Submissao> submissoes = getSubmissaoes();
		Iterator<Submissao> it = submissoes.iterator();
		while(it.hasNext()) {
			Submissao atual = it.next();
			if (atual.equals(Submissao))
				return false;
		}
		submissoes.add(Submissao);
		Serializar.salvarObjeto(new File(CAMINHO), submissoes);
		return true;
//		FileWriter fw = new FileWriter("./src/controle/SubmissaosBD.txt", true);
//		String dadosSubmissao = Submissao.getMatricula() + SEPARADOR + Submissao.getNome() +
//		SEPARADOR + Submissao.getEnunciado() + SEPARADOR + Submissao.getData() +
//		SEPARADOR + Submissao.getDataEntrega();
//		fw.write(FIM_DE_LINHA + dadosSubmissao);
//		fw.close();
//		return false;
	}
	
	public static boolean removeSubmissao(int id) {
		List<Submissao> submissoes = getSubmissaoes();
		Iterator<Submissao> it = submissoes.iterator();
		while(it.hasNext()) {
			Submissao atual = it.next();
			if (atual.getId() == id) {
				submissoes.remove(atual);
				try {
					Serializar.salvarObjeto(new File(CAMINHO), submissoes);
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
		List<Submissao> submissoes = getSubmissaoes();
		Iterator<Submissao> it = submissoes.iterator();
		while(it.hasNext()) {
			Submissao atual = it.next();
			if (atual.equals(sub)) {
				int indice = submissoes.indexOf(atual);
				submissoes.remove(atual);
				submissoes.add(indice, sub);
				try {
					Serializar.salvarObjeto(new File(CAMINHO), submissoes);
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
	
//	private static Submissao criaSubmissao(String dados) throws Exception {
//		String[] tupla = dados.split(SEPARADOR);
//		int id = Integer.parseInt(tupla[0]);
//		String nome = tupla[1];
//		String enunciado = tupla[2];
//		Calendar data = criaCalendario(tupla[3]);
//		Calendar dataEntrega = criaCalendario(tupla[4]);
//		return new Submissao(id, nome, enunciado, data, dataEntrega);
//	}
//	
//	private static Calendar criaCalendario(String cal) {
//		String[] date = cal.split("/");
//		return new GregorianCalendar(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
//	}

//	public static String[] getSubmissao(Submissao Submissao) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public static void addSubmissao(Submissao Submissao, String turma) {
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
			Submissao sub1 = new Submissao("20821200", new GregorianCalendar(), "caminho/do/arquivo.py");
			Submissao sub2 = new Submissao("20821202", new GregorianCalendar(), "caminho/do/arquivo2.py");
			
			System.out.println("Cadastrando!");
			SubmissaoBD.cadastraSubmissao(sub1);
			System.out.println(SubmissaoBD.getSubmissaoes().toString());
			System.out.println("Cadastrando!");
			SubmissaoBD.cadastraSubmissao(sub2);
			System.out.println(SubmissaoBD.getSubmissaoes().toString());
		
			System.out.println("Removendo!");
			SubmissaoBD.removeSubmissao(1);
			System.out.println(SubmissaoBD.getSubmissaoes().toString());
			System.out.println("Atualizando!");
			sub2.setComentario("SAi dai Seu Jegue!");
			System.out.println("Atualizou? " + SubmissaoBD.atualizaSubmissao(sub2));
			System.out.println(SubmissaoBD.getSubmissaoes().toString());
		} catch (IOException e) {
			System.out.print(e.getMessage());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
