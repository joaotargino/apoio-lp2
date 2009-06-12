package users;

import java.util.GregorianCalendar;

public class Exercicio {

	private GregorianCalendar data;
	private GregorianCalendar dataEntrega;
	private String nome;
	private String enunciado;
	private int id;

	public Exercicio(GregorianCalendar data, GregorianCalendar dataEntrega,
			String nome, String enunciado, int id) throws Exception {
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

	public GregorianCalendar getData() {
		return data;
	}

	public void setData(GregorianCalendar data) {
		this.data = data;
	}

	public GregorianCalendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(GregorianCalendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
