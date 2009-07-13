package testes;

import static org.junit.Assert.*;

import org.hibernate.annotations.Entity;
import org.junit.Test;

import users.Usuario;

public class UsuarioTest {
	static Usuario user;

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
		
	}

}
