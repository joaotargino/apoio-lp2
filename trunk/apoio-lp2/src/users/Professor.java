package users;

public class Professor extends Moderador{

	public Professor(String nome, String login, String senha, String matricula,
			String email) throws Exception {
		super(nome, login, senha, matricula, email);
		// TODO Auto-generated constructor stub
	}
	
	public boolean alocaAluno(Moderador monitor, Aluno aluno) {
		return false;
	}
	
	public boolean cadastraMonitor(Moderador monitor) {
		return false;
	}
	
	public boolean deletaMonitor(Moderador monitor) {
		return false;
	}
	
	public boolean fechaTurma() {
		return false;
	}
	
	public boolean deletaAluno(Aluno aluno) {
		return false;
	}

}
