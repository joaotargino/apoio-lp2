package disciplina;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import util.Util;

/**
 * Classe que cria exercicios
 * 
 * @author Joao Paulo
 * @author Jessica Priscila
 * @author Erickson Filipe
 * @author Arnett Rufino
 *
 */
public class Exercicio implements Serializable {

    private Calendar data;
    private Calendar dataEntrega;
    private String nome;
    private String descricao;
    private int id;

    private List<String> questoes = new ArrayList();

    private Exercicio() {
    }

    public Exercicio(String nome, String descricao, Calendar dataEntrega,
            List<String> questoes) throws Exception {
        if (nome == null || descricao == null || dataEntrega == null) {
            throw new IllegalArgumentException("TODOS OS CAMPOS PRECISAM SER PREENCHIDOS");
        }

        this.questoes = questoes;
        this.data = new GregorianCalendar();
        
        if (dataEntrega.compareTo(data) < 0) {
            throw new Exception("A DATA DE ENTREGA PRECISA SER MAIOR QUE A DATA DE CRIAÇÃO");
        }
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
     * muda a data para a entrega do exercicio
     * @param dataEntrega
     * @throws Exception 
     */
    public void setDataEntrega(Calendar dataEntrega) throws Exception {
    	if (dataEntrega.compareTo(data) < 0) 
    		throw new Exception("A DATA DE ENTREGA PRECISA SER MAIOR QUE A DATA DE CRIACÃO DO EXERC�CIO!");
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
     * muda o nome do exercicio
     * @param nome
     * @throws Exception 
     */
    public void setNome(String nome) throws Exception {
    	if (isOnlySpace(nome)) 
    		throw new Exception("O NOME DO EXERCÍCIO NÃO PODE SER APENAS ESPAÇOS!");
    	
    	if (nome == null) {
    		throw new Exception("O NOME DO EXERCÍCIO NÃO PODE SER NULO!");
    	}
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
     * @throws Exception 
     */
    public void setDescricao(String descricao) throws Exception {
    	if (isOnlySpace(descricao)) 
    		throw new Exception("A DESCRIÇÃO DO EXERCÍCIO NÃO PODE SER APENAS ESPAÇOS!");
    	if (descricao == null) {
    		throw new Exception("A DESCRIÇÃO DO EXERCÍCIO NÃO PODE SER NULA!");
    	}
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
     * @throws Exception 
     */
    public void setId(int id) throws Exception {
    	if (Util.temId(id, "exercicio"))
    		throw new Exception("J� EXISTE UM EXERCICIO COM ESSE ID!");
        this.id = id;
    }

    public List<String> getQuestoes(){
        return questoes;
    }

    public String exibirQuestoes() {

        String stringQuestoes = "";
        Iterator questao = getQuestoes().iterator();
        while (questao.hasNext()) {
            stringQuestoes += questao.next().toString() + util.IO.NOVA_LINHA;
        }
        return stringQuestoes;
    }
    
	/**
	 * Verifica se a string s� tem espa�o
	 * 
	 * @param string
	 *            - a string a ser verificada se s� tem espa�os
	 * @return true se s� tem espa�os, false caso contr�rio.
	 */
	private boolean isOnlySpace(String string) {
		int space = 0;
		for (int letter = 0; letter < string.length(); letter++) {
			if (Character.isSpaceChar(string.charAt(letter))) {
				space++;
			}
		}

		if (space == string.length()) {
			return true;
		}
		return false;
	}

    @Override
    public boolean equals(Object arg0) {
        if (arg0 instanceof Exercicio) {
            Exercicio exercicio = (Exercicio) arg0;
            if (exercicio.getId() == getId() || exercicio.getNome().equals(getNome())) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("deprecation")
	@Override
    public String toString() {
        return "Id: " + getId() + " | Nome: " + getNome() + " | Descrição: " + getDescricao() + " | Data Entrega: " + getDataEntrega().getTime().toLocaleString().split(" ")[0] + util.IO.NOVA_LINHA;
    }
}
