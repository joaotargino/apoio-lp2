package disciplina;
//fsdf
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercicios {

	private String nome;
	private double nota = 0;
	private Map<String, Double> labs;
	

	public Exercicios(String nome, double nota) {
		this.nome = nome;
		this.nota = nota;
		
		labs = new HashMap<String,Double>();

		// sei como fzr isso nao ¬¬ >> labs = new HashMap;

	}

	public void setNota() {
	} // isso vai ficar aqui mesmo ? 0o

}
