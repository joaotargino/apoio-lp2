package users;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

	Aluno aluno;

	@Before
	public void setUp() throws Exception {
		aluno = new Aluno("arnett", "20821282", "12345", "arnett@email.com");
	}

	@Test
	public void submeterExercicioTest() {
		Exercicio exercicio = new Exercicio();
		assertTrue(aluno.submeterExercicio(exercicio));
		assertFalse(aluno.submeterExercicio(exercicio));
		assertFalse(aluno.submeterExercicio(null));
	}

	public void 
}
