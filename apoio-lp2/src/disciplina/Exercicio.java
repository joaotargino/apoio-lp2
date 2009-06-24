package disciplina;

import java.io.Serializable;
import java.util.Calendar;

public class Exercicio implements Serializable{

	private Calendar data;
	private Calendar dataEntrega;
	private String nome;
	private String enunciado;
	private int id;

	public Exercicio(int id, String nome,  String enunciado, Calendar data2,
			Calendar dataEntrega2 ) throws Exception {
		if (nome == null || enunciado == null || data2 == null || dataEntrega2 == null) {
			throw new IllegalArgumentException();
		}
		if (dataEntrega2.compareTo(data2) < 0) {
			throw new Exception();
		}
		this.data = data2;
		this.dataEntrega = dataEntrega2;
		this.nome = nome;
		this.enunciado = enunciado;
		this.id = id;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
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
