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
			fail("Usuario deveria ter sido criado!");
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
	
	@Test
	public void emailTest() {
		assertFalse(user.setEmail(""));
		assertFalse(user.setEmail("        @    .    "));
		assertFalse(user.setEmail(null));
		assertFalse(user.setEmail("@"));
		assertFalse(user.setEmail("a@email"));
		assertFalse(user.setEmail("a@email."));
		assertFalse(user.setEmail("."));
		assertTrue(user.setEmail("erickson@email.com"));
		assertTrue(user.setEmail("erickson@email.com.br"));
		assertTrue(user.setEmail("ericksonfilipe@gmail.com.br"));
	}
	
	@Test(expected=Exception.class)
	public void loginPequenoTest() throws Exception {
		new Usuario("nomeUsuario", "logi", "senhausuario", "matriculausuario", "email@email.com", "turma");
	}
	
	@Test(expected=Exception.class)
	public void senhaPequenaTest() throws Exception {
		new Usuario("nomeUsuario", "loginn", "senh", "matriculausuario", "email@email.com", "turma");
	}
	
	@Test(expected=Exception.class)
	public void mudaSenhaVazio() throws Exception {
		user.setSenha("");
	}
	
	@Test(expected=Exception.class)
	public void mudaSenhaSoEspacos() throws Exception {
		user.setSenha("         ");
	}
	
	@Test(expected=Exception.class)
	public void mudaSenhaPoucosCaracteres() throws Exception {
		user.setSenha("1234");
	}
	
	@Test(expected=Exception.class)
	public void mudaSenhaNulo() throws Exception {
		user.setSenha(null);
	}
	
	@Test
	public void mudaSenhaNormal() throws Exception {
		user.setSenha("novaSenha");
	}
	
	@Test(expected=Exception.class)
	public void mudaNomeSoEspacos() throws Exception {
		user.setNome("        ");
	}
	
	@Test(expected=Exception.class)
	public void mudaNomeNulo() throws Exception {
		user.setNome(null);
	}
	
	@Test
	public void mudaNomeNormal() throws Exception {
		user.setNome("Severino");
	}
	
	@Test(expected=Exception.class)
	public void mudaMatriculaSoEspacos() throws Exception {
		user.setMatricula("        ");
	}
	
	@Test(expected=Exception.class)
	public void mudaMatriculaNula() throws Exception {
		user.setMatricula(null);
	}

}
