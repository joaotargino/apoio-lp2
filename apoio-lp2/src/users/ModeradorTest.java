package users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controle.Submissao;

import java.util.GregorianCalendar;

public class ModeradorTest {
	
	private Aluno aluno1;
	private Aluno aluno2;
	private Moderador monitor;

	@Before
	public void setUp() throws Exception {
		aluno1 = new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
		aluno2 = new Aluno("Jessica","20821205", "senha", "20821205", "jessicadesousacg@gmail.com","2009.1");
		monitor = new Moderador("Monitor", "20720000", "12345", "20720000", "monitor@lp2.ufcg.edu.br", "2009.1");
	}
	
	//testes cadastra aluno
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullNome() throws Exception {
		new Aluno(null,"20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullLogin() throws Exception {
		new Aluno("Joao",null, "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullSenha() throws Exception {
		new Aluno("Joao","20821333", null, "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullMatricula() throws Exception {
		new Aluno("Joao","20821333", "senha", null, "joaotargino@gmail.com", "2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullEmail() throws Exception {
		new Aluno("Joao","20821333", "senha", "20821333", null,"2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNullTurma() throws Exception {
		new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com",null);
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComNomeVazio() throws Exception {
		new Aluno("","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComLoginVazio() throws Exception {
		new Aluno("Joao","", "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComSenhaVazia() throws Exception {
		new Aluno("Joao","20821333", "", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComMatriculaVazia() throws Exception {
		new Aluno("Joao","20821333", "senha", "", "joaotargino@gmail.com", "2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComEmailVazio() throws Exception {
		new Aluno("Joao","20821333", "senha", "20821333", "","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoComTurmaVazia() throws Exception {
		new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","");
	}
	
	@Test
	public void testEqualsComMesmaMatricula() throws Exception{
		aluno1 = new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
		aluno2 = new Aluno("Jes","20821333", "senha", "20821205", "jessicadesousacg@gmail.com","2009.1");
		assertFalse(aluno1.equals(aluno2));
	}
	
	@Test
	public void testEqualsComMesmoEmail() throws Exception{
		aluno1 = new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
		aluno2 = new Aluno("Jes","20821205", "senha", "20821205", "joaotargino@gmail.com","2009.1");
		assertFalse(aluno1.equals(aluno2));
	}
	
	@Test
	public void testModeradorCadastraAluno() throws Exception{
		assertTrue(monitor.cadastraAluno("Joao", "20001000", "12345", "20001000", "jp@gmail.com", "2009.1"));
		assertFalse(monitor.cadastraAluno("Joao", "20001000", "12345", "20001000", "jp@gmail.com", "2009.1"));
		assertFalse(monitor.cadastraAluno("Jessica", "20001000", "12345", "20001000", "jes@gmail.com", "2009.1"));
		assertTrue(monitor.cadastraAluno("Jessica", "20002000", "12345", "20002000", "jes@gmail.com", "2009.1"));
	}
	
	@Test
	public void testExercicioComNotaInvalida() {
		Submissao submissao = new Submissao("20821200", new GregorianCalendar(), "caminho");
		assertTrue(monitor.setNotaAluno(submissao, "20821200", 9.0));
		Submissao submissao2 = new Submissao("20821200", new GregorianCalendar(), "caminho");
		assertFalse(monitor.setNotaAluno(submissao2, "20821200", -1.0));
		Submissao submissao3 = new Submissao("20821200", new GregorianCalendar(), "caminho");
		assertFalse(monitor.setNotaAluno(submissao3, "20821200", 10.5));
	}
	
	//testa abrir turma 
	@Test
	public void testAbrirTurma(){
		monitor.abrirTurma("2009.1");
		Assert.assertEquals("Turma invalida ou inexistente", "2009.1" , monitor.getTurma());
	}
	
	
}