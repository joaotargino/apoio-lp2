package disciplina;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class ExercicioTest {
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstrutor1() throws Exception {
		new Exercicio(0,  "" , "" , null , null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutor2() throws Exception {
		new Exercicio(1, "" , "", new GregorianCalendar(), null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testConstrutor3() throws Exception {
		new Exercicio(1, "lab1" , "enunciado", null, new GregorianCalendar());
	}

	@Test(expected=Exception.class)
	public void testConstrutor4() throws Exception {
		GregorianCalendar dataMenor = new GregorianCalendar(1999, 1, 1);
		GregorianCalendar dataMaior = new GregorianCalendar();
		new Exercicio( 0 , "", "", dataMaior, dataMenor);
	}

	
}
