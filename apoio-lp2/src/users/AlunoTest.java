package users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import disciplina.Exercicio;

public class AlunoTest {

	Aluno aluno;

	@Before
	public void setUp() throws Exception {
		aluno = new Aluno("arnett", "20821282", "12345", "20821282", "arnett@email.com");
	}

	@Test
	public void submeterExercicioTest() throws Exception {
		GregorianCalendar dataMaior = new GregorianCalendar(2009, 10, 10);
		GregorianCalendar dataMenor = new GregorianCalendar();
		Exercicio exercicio = new Exercicio(dataMenor, dataMaior, "nome", "enunciado", 100);
		assertTrue(aluno.submeterExercicio(exercicio));
		//Mesmo exercicio sendo submetido duas vezes
		assertFalse(aluno.submeterExercicio(exercicio));
		try {
			assertFalse(aluno.submeterExercicio(null));
			Assert.fail();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
