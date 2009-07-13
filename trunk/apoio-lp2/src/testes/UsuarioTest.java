package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import users.Usuario;

public class UsuarioTest {
	static Usuario user;
	
	@Before
	public void setUp() {
		try {
			user = new Usuario("Erickson", "ericksonfgds",
					"senhadeerickson", "20821200",
					"eicksonfgds@lcc.ufcg.edu.br", "2009.1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void construtorNuloTest() {
		try {
			new Usuario(null, "loginusuario", "senhausuario", "matriculausuario", "email@email.com", "turma");
			fail("Usuario nao pode ter nome nulo!");
		} catch (Exception e) {
		}
		
		try {
			new Usuario("usuario", null, "senhausuario", "matriculausuario", "email@email.com", "turma");
			fail("Usuario nao pode ter login nulo!");
		} catch (Exception e) {
		}
		
		try {
			new Usuario("usuario", "loginusuario", null, "matriculausuario", "email@email.com", "turma");
			fail("Usuario nao pode ter senha nula!");
		} catch (Exception e) {
		}
		
		try {
			new Usuario("usuario", "loginusuario", "senhausuario", null, "email@email.com", "turma");
			fail("Usuario nao pode ter matricula nula!");
		} catch (Exception e) {
		}
		
		try {
			new Usuario("usuario", "loginusuario", "senhausuario", "matriculausuario", null, "turma");
			fail("Usuario nao pode ter email nulo!");
		} catch (Exception e) {
		}
	}
	
	public void emailTest() {
		assertFalse(user.setEmail(""));
		assertFalse(user.setEmail("@"));
		assertFalse(user.setEmail("a@email"));
		assertFalse(user.setEmail("a@email."));
		assertFalse(user.setEmail("."));
		assertTrue(user.setEmail("erickson@email.com"));
		assertTrue(user.setEmail("erickson@email.com.br"));
		assertTrue(user.setEmail("ericksonfilipe@gmail.com.br"));
	}
	
	

}
