package users;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class ModeradorTest {
	
	private Aluno aluno1;
	private Aluno aluno2;
	private Moderador monitor;

	@Before
	public void setUp() throws Exception {
		aluno1 = new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
		aluno2 = new Aluno("Jessica","20821205", "senha", "20821205", "jessicadesousacg@gmail.com","2009.1");
		monitor = new Moderador("Monitor", "20720000", "12345", "20720000", "monitor@lp2.ufcg.edu.br");
	}
	
	//testes cadastra aluno
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullNome() {
		new Aluno(null,"20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullLogin() {
		new Aluno("Joao",null, "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullSenha() {
		new Aluno("Joao","20821333", null, "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullMatricula() {
		new Aluno("Joao","20821333", "senha", null, "joaotargino@gmail.com", "2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullEmail() {
		new Aluno("Joao","20821333", "senha", "20821333", null,"2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullTurma() {
		new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com",null);
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNomeVazio() {
		new Aluno("","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComLoginVazio() {
		new Aluno("Joao","", "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComSenhaVazia() {
		new Aluno("Joao","20821333", "", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComMatriculaVazia() {
		new Aluno("Joao","20821333", "senha", "", "joaotargino@gmail.com", "2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComEmailVazio() {
		new Aluno("Joao","20821333", "senha", "20821333", "","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComTurmaVazia() {
		new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","");
	}
	
	@Test
	public void testEqualsComMesmaMatricula(){
		aluno1 = new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
		aluno2 = new Aluno("Jes","20821333", "senha", "20821205", "jessicadesousacg@gmail.com","2009.1");
		assertFalse(aluno1.equals(aluno2));
	}
	
	@Test
	public void testEqualsComMesmoEmail(){
		aluno1 = new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
		aluno2 = new Aluno("Jes","20821205", "senha", "20821205", "joaotargino@gmail.com","2009.1");
		assertFalse(aluno1.equals(aluno2));
	}
	
	@Test
	public void testModeradorCadastraAluno(){
		assertTrue(monitor.cadastraAluno("Joao", "20001000", "12345", "20001000", "jp@gmail.com"));
		assertFalse(monitor.cadastraAluno("Joao", "20001000", "12345", "20001000", "jp@gmail.com"));
		assertFalse(monitor.cadastraAluno("Jessica", "20001000", "12345", "20001000", "jes@gmail.com"));
		assertTrue(monitor.cadastraAluno("Jessica", "20002000", "12345", "20002000", "jes@gmail.com"));
	}
	
	
	//testes submeter nota
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioComNullNota(){
		lab = new Exercicio("lab1" , null); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioComNullNome(){
		lab = new Exercicio(null, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioComNomeVazio() {
		new Exercicio("", 10);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioComNomeInvalido() {
		new Exercicio(2, 7.6);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioComNotaInvalida() {
		new Exercicio("lab2", "a");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioComNotaInvalida() {
		new Exercicio("lab2", &);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioComNotaInvalida() {
		new Exercicio("lab2", -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioComNotaInvalida() {
		new Exercicio("lab2", 11);
	}
	
	@Test
	public void testExercicioComNotaInvalida() {
		exercicio = new Exercicio("lab2", -1);
		assertFalse(monitor.setNotaAluno(exercicio, aluno));
		exercicio2 = new Exercicio("lab3" , 10);
		assertTrue(monitor.setNotaAluno(exercicio2, aluno));
		exercicio3 = new Exercicio("lab11" , 11);
		assertFalse(monitor.setNotaAluno(exercicio3,aluno));
	}
	
	//testa abrir turma 
	@Test
	public void testAbrirTurma(){
		monitor.abrirTurma("2009.1");
		Assert.assertEquals("Turma inválida ou inexistente", "2009.1" , monitor.getTurma());
	}
	
	
}