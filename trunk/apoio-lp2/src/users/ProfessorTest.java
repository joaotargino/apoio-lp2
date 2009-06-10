package users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {

		Professor prof;

		@Before
		public void criaPAs() {
			prof = new Professor("Raquel", "raquel", "12345", 
					"20000000", "raquelvl at gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithNullName(){
			new Professor(null, "raquel", "12345", 
					"20000000", "raquelvl@gmail.com");
		}

		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithNullLogin(){
			new Professor("Raquel", null, "12345", 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithNullPassword(){
			new Professor("Raquel", "raquel", null, 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithNullMatricula(){
			new Professor("Raquel", "raquel", "12345", 
					null, "raquelvl@gmail.com");
		}

		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithEmptyName(){
			new Professor("", "raquel", "12345", 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithEmptyLogin(){
			new Professor("Raquel", " ", "12345", 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithEmptyPassword(){
			new Professor("Raquel", "raquel", "", 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithEmptyMatricula(){
			new Professor("", "raquel", "12345", 
					" ", "raquelvl at gmail.com");
		}
		



	}
