package users;

import controle.BD;


public class Aluno extends Usuario{

	static final String NOVA_LINHA = System.getProperty("line.separator");
	
	public Aluno(String nome, String login, String senha, String matricula, String email) throws Exception {
		super(nome, login, senha, matricula, email);
	}
	
	public boolean submeterExercicio(Exercicio exercicio){
		//TODO Colocar data limite de entrega...
		if (BD.getExercicios().contains(exercicio)) {
			BD.addSubmissao(exercicio);
			return true;
		} return false;
			
	}
	
	@Override
	public String toString(){
			return "NOME: " +this.getNome() + NOVA_LINHA +
			"LOGIN: " + this.getLogin() + NOVA_LINHA +
			"EMAIL: " + this.getEmail();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Aluno) {
			Aluno aluno = (Aluno) obj;
			if (aluno.getLogin().equals(getLogin()))
				return true;
		}
		return false;
	}
}