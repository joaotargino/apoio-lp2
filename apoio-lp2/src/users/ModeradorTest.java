package users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controle.*;



public class ModeradorTest {
	
	private Moderador monitor;

	@Before
	public void setUp() throws Exception {
		monitor = new Moderador("Monitor", "20720000", "12345", "20720000", "monitor@lp2.ufcg.edu.br");
	}
	
	@Test
	public void testModeradorCadastraAluno() throws Exception{
		assertTrue(monitor.cadastraAluno("Joao", "20001000", "12345", "20001000", "jp@gmail.com"));
		assertFalse(monitor.cadastraAluno("Joao", "20001000", "12345", "20001000", "jp@gmail.com"));
		assertFalse(monitor.cadastraAluno("Jessica", "20001000", "12345", "20001000", "jes@gmail.com"));
		assertTrue(monitor.cadastraAluno("Jessica", "20002000", "12345", "20002000", "jes@gmail.com"));
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
		Assert.assertEquals("Turma inválida ou inexistente", "2009.1" , monitor.getTurma());
	}
	
	
}