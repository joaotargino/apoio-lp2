package controle;

import java.util.GregorianCalendar;

public class Submissao {
	
	private GregorianCalendar dataDeEntrega;
	private String caminho, login, comentario;
	private Double nota;
	
	public Submissao( String login, GregorianCalendar dataDeEntrega, String caminho ) {
		this.login = login;
		this.dataDeEntrega = dataDeEntrega;
		this.caminho = caminho;
		
	}
	
}