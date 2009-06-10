package users;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

//algo lah :D
import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class ModeradorTest {
	
	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	private Moderador monitor;

	@Before
	public void setUp() throws Exception {
		aluno = new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
		aluna = new Aluno("Jessica","20821205", "senha", "20821205", "jessicadesousacg@gmail.com","2009.1");
		monitor = new Moderador("Monitor", "20720000", "12345", "20720000", "monitor@lp2.ufcg.edu.br");
	}
	
	//testes cadastra aluno
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithNullNome() {
		new Aluno(null,"20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithNullLogin() {
		new Aluno("Joao",null, "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithNullSenha() {
		new Aluno("Joao","20821333", null, "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithNullMatricula() {
		new Aluno("Joao","20821333", "senha", null, "joaotargino@gmail.com", "2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithNullEmail() {
		new Aluno("Joao","20821333", "senha", "20821333", null,"2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithNullTurma() {
		new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com",null);
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithEmptyNome() {
		new Aluno("","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithEmptyLogin() {
		new Aluno("Joao","", "senha", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithEmptySenha() {
		new Aluno("Joao","20821333", "", "20821333", "joaotargino@gmail.com","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithEmptyMatricula() {
		new Aluno("Joao","20821333", "senha", "", "joaotargino@gmail.com", "2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithEmptyEmail() {
		new Aluno("Joao","20821333", "senha", "20821333", "","2009.1");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testAlunoWithEmptyTurma() {
		new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","");
	}
	
	@Test
	public void testEqualsWithSameMatricula(){
		aluno1 = new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
		aluno2 = new Aluno("Jes","20821333", "senha", "20821205", "jessicadesousacg@gmail.com","2009.1");
		assertFalse(aluno1.equals(aluno2));
	}
	
	@Test
	public void testEqualsWithSameEmail(){
		aluno1 = new Aluno("Joao","20821333", "senha", "20821333", "joaotargino@gmail.com","2009.1");
		aluno2 = new Aluno("Jes","20821205", "senha", "20821205", "joaotargino@gmail.com","2009.1");
		assertFalse(aluno1.equals(aluno2));
	}
	
	
	//testes submeter nota
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioWithNullNota(){
		lab = new Exercicio("lab1" , null); 
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioWithNullNome(){
		lab = new Exercicio(null, 10);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioWithEmptyNome() {
		new Exercicio("", 10);
	}
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioWithInvalidNome() {
		new Exercicio(2, 7.6);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioWithInvalidNota() {
		new Exercicio("lab2", "a");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioWithInvalidNota() {
		new Exercicio("lab2", &);
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testExercicioWithInvalidNota() {
		new Exercicio("lab2", -1);
	} // isso existe????
	
	@Test
	public void testExercicioWithInvalidNota() {
		exercicio = new Exercicio("lab2", -1);
		assertFalse(monitor.setNotaAluno(exercicio, aluno));
		exercicio2 = new Exercicio("lab3" , 10);
		assertTrue(monitor.setNotaAluno(exercicio2, aluno));
		exercicio3 = new Exercicio("lab11" , 11);
		assertFalse(monitor.setNotaAluno(exercicio3,aluno));
	}
	
	//o construtor de exercicio eh assim, ne? 
	
	
	
}