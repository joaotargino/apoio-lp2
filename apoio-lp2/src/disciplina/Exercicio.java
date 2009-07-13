package disciplina;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

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
	private String descricao;
	private int id;
    private static List<String> questoes;
	
	private Exercicio() {}

	public Exercicio(String nome,  String descricao, Calendar data,
			Calendar dataEntrega, List<String> questoes ) throws Exception {
		if (nome == null || descricao == null || data == null || dataEntrega == null) {
			throw new IllegalArgumentException("TODOS OS CAMPOS PRECISAM SER PREENCHIDOS");
		}
		if (dataEntrega.compareTo(data) < 0) {
			throw new Exception("A DATA DE ENTREGA PRECISA SER MAIOR QUE A DATA DE CRIAÇÃO");
		}
        this.questoes = questoes;
		this.data = data;
		this.dataEntrega = dataEntrega;
		this.nome = nome;
		this.descricao = descricao;
		this.id = util.Util.geraId("exercicio");
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
	public String getDescricao() {
		return descricao;
	}

	/**
	 * seta a descricao do exercicio
	 * @param descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

    public static String exibirQuestoes(){
        String stringQuestoes = "";
        Iterator questao = questoes.iterator();
        while(questao.hasNext()){
            stringQuestoes += questao.next().toString() + dados.IO.NOVA_LINHA;
        }
        return stringQuestoes;
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
			return "Id: " + getId() + " | Nome: "  + getNome() + " | Descrição: " + getDescricao() + " | Data Entrega: " + getDataEntrega().getTime().toLocaleString().split(" ")[0] + dados.IO.NOVA_LINHA;
		}	
}
