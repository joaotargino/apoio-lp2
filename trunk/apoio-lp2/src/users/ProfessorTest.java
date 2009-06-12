package users;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProfessorTest {

		Professor prof;
		Moderador monitor1, monitor2;
		Aluno aluno1, aluno2, aluno3;

		@Before
		public void setUp() throws Exception {
			prof = new Professor("Raquel", "raquel", "12345", 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithNullName() throws Exception{
			new Professor(null, "raquel", "12345", 
					"20000000", "raquelvl@gmail.com");
		}

		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithNullLogin() throws Exception{
			new Professor("Raquel", null, "12345", 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithNullPassword() throws Exception{
			new Professor("Raquel", "raquel", null, 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithNullMatricula() throws Exception{
			new Professor("Raquel", "raquel", "12345", 
					null, "raquelvl@gmail.com");
		}

		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithEmptyName() throws Exception{
			new Professor("", "raquel", "12345", 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithInvalidLogin() throws Exception{
			new Professor("Raquel", " ", "12345", 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithEmptyPassword() throws Exception{
			new Professor("Raquel", "raquel", "", 
					"20000000", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithInvalidMatricula() throws Exception{
			new Professor("", "raquel", "12345", 
					" ", "raquelvl@gmail.com");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testProfessorWithInvalidEmail() throws Exception{
			new Professor("Raquel", "raquel", "12345", "20000000", "raquelatgmail.com");
		}

		@Test
		public void testProfessorCadastraMonitor(){
			assertTrue(prof.cadastraMonitor("Filipe", "20001000", "12345", "20001000", "filipe@gmail.com"));
			assertFalse(prof.cadastraMonitor("Filipe", "20001000", "12345", "20001000", "filipe@gmail.com"));
			assertFalse(prof.cadastraMonitor("David", "20001000", "12345", "20001000", "david@gmail.com"));
			assertFalse(prof.cadastraMonitor("David", "20002000", "12345", "20002000", "david@gmail.com"));
		}
		
		public void testProfessorAlocaAluno(){
			prof.cadastraMonitor("Filipe", "20001000", "12345", "20001000", "filipe@gmail.com");
			prof.cadastraMonitor("David", "20002000", "12345", "20002000", "david@gmail.com");
			prof.cadastraAluno("Jessica", "20821205", "12345", "20821205", "jessica@gmail.com");
			assertTrue(prof.alocaAluno("20001000", "20821205"));
			assertTrue(prof.getTutelados("20001000").contains("20821205"));
			assertTrue(prof.alocaAluno("20002000", "20821205"));
			assertTrue(prof.getTutelados("20002000").contains("20821205"));
			assertFalse(prof.getTutelados("20001000").contains("20821205"));
			assertFalse(prof.alocaAluno("20000000", "20821205"));
			assertFalse(prof.alocaAluno("20001000", "20821200"));
			assertFalse(prof.alocaAluno("20000000", "20821200"));
		}
		
		public void testProfessorDeletaMonitor(){
			prof.cadastraMonitor("Filipe", "20001000", "12345", "20001000", "filipe@gmail.com");
			prof.cadastraMonitor("David", "20002000", "12345", "20002000", "david@gmail.com");
			assertTrue(prof.getMonitores().contains("20001000"));
			assertTrue(prof.getMonitores().contains("20002000"));
			prof.deletaMonitor("20001000");
			assertTrue(prof.getMonitores().contains("20002000"));
			assertFalse(prof.getMonitores().contains("20001000"));
		}
		
		public void testProfessorDeletaAluno(){
			prof.cadastraAluno("Jessica", "20821205", "12345", "20821205", "jessica@gmail.com");
			prof.cadastraAluno("Joao", "20821333", "12345", "20821333", "joao@gmail.com");
			assertTrue(prof.getAlunos().contains("20821205"));
			assertTrue(prof.getAlunos().contains("20821333"));
			prof.deletaMonitor("20821205");
			assertTrue(prof.getMonitores().contains("20821333"));
			assertFalse(prof.getMonitores().contains("20821205"));		
		}

	}
