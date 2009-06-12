import Aluno;
import Usuario;

public class Moderador extends Usuario{

	private Aluno aluno;
	private String turma = "";

	public Moderador(String nome, String login, String senha, String email) throws Exception {
		super(nome, login, senha, email);
	}
	
	public void abrirTurma(String turma) {
		this.turma = turma;
	}
	public void cadastraAluno(String nome, String login, String senha, String email) throws Exception{
		Aluno aluno = new Aluno(nome, login, senha, email);
		BD.addAluno(aluno, turma);
		
	}
	
	public String getTurma(){
		return this.turma;
	}
	public void verTutelados()

}
