package disciplina;

import java.io.Serializable;
import java.util.Calendar;

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
			return "Id: " + getId() + " | Nome: "  + getNome();
		}	
}
