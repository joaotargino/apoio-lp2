package disciplina;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que cria exercicios
 * 
 * @author Joao Paulo
 * @author Jessica Priscila
 * @author Erickson Filipe
 * @author Arnett Rufino
 *
 */
public class Exercicio implements Serializable{

	private Calendar data;
	private Calendar dataEntrega;
	private String nome;
	private String enunciado;
	private int id;
	
	private Exercicio() {}

	public Exercicio(int id, String nome,  String enunciado, Calendar data,
			Calendar dataEntrega ) throws Exception {
		if (nome == null || enunciado == null || data == null || dataEntrega == null) {
			throw new IllegalArgumentException();
		}
		if (dataEntrega.compareTo(data) < 0) {
			throw new Exception();
		}
		this.data = data;
		this.dataEntrega = dataEntrega;
		this.nome = nome;
		this.enunciado = enunciado;
		this.id = id;
	}

	/**
	 * data em que o exercicio foi criado
	 * @return data em que o exercicio foi criado
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 *
	 * @param data
	 */
	public void setData(Calendar data) {
		this.data = data;
	}

	/**
	 * prazo para a entrega do exercicio
	 * @return a data limite para a entrega do lab
	 */
	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	/**
	 * seta a data para a entrega do exercicio
	 * @param dataEntrega
	 */
	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	/**
	 * 
	 * @return o nome do exercicio
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * seta o nome do exercicio
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return descricao do exercicio
	 */
	public String getEnunciado() {
		return enunciado;
	}

	/**
	 * seta a descricao do exercicio
	 * @param enunciado
	 */
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	/**
	 * @return o id do exercicio
	 */
	public int getId() {
		return id;
	}

	/**
	 * atribui um id ao exercicio
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Exercicio) {
			Exercicio exercicio = (Exercicio) arg0;
			if (exercicio.getId() == getId() || exercicio.getNome().equals(getNome()))
				return true;
		}
		return false;
	}
	
	@Override
		public String toString() {
			return "Id: " + getId() + " | Nome: "  + getNome() + " | Data Entrega: " + getDataEntrega().getTime().toLocaleString().split(" ")[0]; 
		}	
}
