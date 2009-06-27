package controle;

import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Toda Submissao precisara de um identificador unico, no caso eu coloquei como sendo id, que antes nao existia como atributo
 * Sera preciso implementar a logica do negocio, visto que o id, provavelmente, serah incrementado automaticamente
 * 
 * @author erickson
 *
 */
public class Submissao implements Serializable{

	private GregorianCalendar dataDeEntrega;
	private String caminho, login, comentario;
	private Double nota;
	private int id, idExercicio;

	private Submissao() {}
	
	public Submissao( int idExercicio, String login, GregorianCalendar dataDeEntrega, String caminho ) {
		this.idExercicio = idExercicio;
		this.login = login;
		this.dataDeEntrega = dataDeEntrega;
		this.caminho = caminho;
		
	}
	
	/**
	 * @return the idExercicio
	 */
	public int getIdExercicio() {
		return idExercicio;
	}

	/**
	 * @param idExercicio the idExercicio to set
	 */
	public void setIdExercicio(int idExercicio) {
		this.idExercicio = idExercicio;
	}

	/**
	 * @return the dataDeEntrega
	 */
	public GregorianCalendar getDataDeEntrega() {
		return dataDeEntrega;
	}

	/**
	 * @param dataDeEntrega the dataDeEntrega to set
	 */
	public void setDataDeEntrega(GregorianCalendar dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	/**
	 * @return the caminho
	 */
	public String getCaminho() {
		return caminho;
	}

	/**
	 * @param caminho the caminho to set
	 */
	public void setCaminho(String caminho) {
		this.caminho = caminho;
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
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the nota
	 */
	public Double getNota() {
		return nota;
	}

	/**
	 * @param nota the nota to set
	 */
	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
}