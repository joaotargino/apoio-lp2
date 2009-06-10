package disciplina;

import java.util.ArrayList;
import java.util.List;

import users.Aluno;

public class Turma {
	
	private String nome;
	private boolean turmaAberta = true;
	List<Aluno> alunosTurma;
	
	public static void main(String[] args){
		Turma turma = new Turma("2008.2"); 
		//System.out.println(turma.getAnoTurma());
		//System.out.println(turma.getPeriodoTurma());
		Aluno aluno = new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
		//System.out.print(aluno.getTurma());
		List<Aluno> alunosTurma = new ArrayList<Aluno>();
		alunosTurma.add(aluno);
		Aluno aluna = new Aluno("Jes","20821205", "senha", "20821205", "jessicadesousacg@gmail.com","2009.1");
		alunosTurma.add(aluna);
		
		for (Aluno estudante : alunosTurma) {
			System.out.println(estudante);
			System.out.println();
		}
		//System.out.println(alunosTurma);
		//turma.addAluno(aluno);
		//turma.listarAlunos();
	}
	
	public Turma(String nome){
		this.nome = nome;
	} //formato do nome AAAA.P ex: 2008.2 2009.1 ( ou preferem AAAAP 20082 20091 ? )
	
	public boolean addAluno(Aluno aluno){
		try{
		alunosTurma.add(aluno);
		return true;
		}catch(Exception ex){
			System.out.println("null?");
			return false;
		}
	}
	
	public void listarAlunos(){
		for (Aluno estudante : alunosTurma) {
			System.out.println(estudante);
			System.out.println();
		}
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public void fecharTurma(){
		turmaAberta = false;
	}
	
	public void abrirTurma(){
		turmaAberta = true;
	}
	
	public String getAnoTurma(){ 
		return this.nome.substring(0,4);
	}
	
	public String getPeriodoTurma(){
		return this.nome.substring(5,6);
	}

}
