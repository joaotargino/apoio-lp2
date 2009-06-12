package disciplina;

import java.util.GregorianCalendar;

import org.junit.Test;

public class ExercicioTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutor1() throws Exception {
		new Exercicio(null, new GregorianCalendar(), "", "", 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutor2() throws Exception {
		new Exercicio(new GregorianCalendar(), null, "", "", 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutor3() throws Exception {
		new Exercicio(new GregorianCalendar(), new GregorianCalendar(), null, "", 0);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutor4() throws Exception {
		new Exercicio(new GregorianCalendar(), new GregorianCalendar(), "", null, 0);
	}

	@Test(expected=Exception.class)
	public void testConstrutor5() throws Exception {
		GregorianCalendar dataMenor = new GregorianCalendar(1999, 1, 1);
		GregorianCalendar dataMaior = new GregorianCalendar();
		new Exercicio(dataMaior, dataMenor, "", "", 0);
	}

	
}
