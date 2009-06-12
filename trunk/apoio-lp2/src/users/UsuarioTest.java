package users;


import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;


public class UsuarioTest {
	
	public class Usr extends Usuario{
		public Usr(String nome, String login, String senha, String matricula, String email) throws Exception {
			super(nome, login, senha, matricula, email);
		}
	}
	private Usuario erickson;
	private Usuario arnett;

	@Before
	public void setUp() throws Exception {
		erickson = new Usr("Erickson", "20821200", "123456", "20821200", "ericksonfilipe@gmail.com");
		arnett = new Usr("Arnett", "20821209", "123456", "20821209", "shrivelfigs@gmail.com");
	}
	
	@Test(expected=Exception.class)
	public void loginNuloTest() throws Exception {
		new Usr("coisaosi", null, "coisi", "20543512", "a@g.c");
	}
	
	@Test(expected=Exception.class)
	public void loginMenosCaracteresQOPermitidoTest() throws Exception {
		new Usr("coisaosi", "055", "coisi", "055", "a@g.c");
	}
	
	@Test(expected=Exception.class)
	public void senhaMenosCaracteresQOPermitidoTest() throws Exception {
		new Usr("coisaosi", "20821200", "123", "20821200", "a@g.c");
	}
	
	@Test(expected=Exception.class)
	public void senhaNulaTest() throws Exception {
		new Usr("coisaosi", "20821200", null, "20821200", "a@g.c");
	}
	
	@Test(expected=Exception.class)
	public void emailTest() throws Exception {
		new Usr("coisaosi", "20821200", "123456", "20821200", "a@gc");
	}
	
	@Test(expected=Exception.class)
	public void nomeNuloTest() throws Exception {
		new Usr(null, "20821200", "123456", "20821200", "a@g.c");
	}
	
	@Test(expected=Exception.class)
	public void alunoComNomeVazioTest() throws Exception {
		new Aluno("","20821333", "senha", "20821333", "joaotargino@gmail.com");
	}
	
	@Test(expected=Exception.class)
	public void aunoComLoginVazioTest() throws Exception {
		new Aluno("Joao","", "senha", "20821333", "joaotargino@gmail.com");
	}
	
	public void InstanciaAlunoSemErroTest(){
		try {
			new Usr("Erickson", "20821200", "123456", "20821200", "a@g.c");
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void MudaSenhaTest() {
		assertEquals("123456", erickson.getSenha());
		assertTrue(erickson.setSenha("123456", "654321"));
		assertEquals("654321", erickson.getSenha());
		assertFalse(arnett.setSenha("senha", "654321"));
		assertFalse(arnett.setSenha("132456", null));
		assertFalse(arnett.setSenha("132456", "256"));
		assertFalse(arnett.getSenha().equals("256"));
	}
	
	@Test
	public void MudaEmailTest() {
		assertTrue(erickson.setEmail("ericksonfilipe@gmail.com"));
		assertFalse(erickson.setEmail("ericksongmail.com"));
		assertFalse(arnett.setEmail("@gmail.com"));
		assertFalse(arnett.setEmail("shrivefigs@gmailcom"));
		assertEquals("ericksonfilipe@gmail.com", erickson.getEmail());
		assertTrue(arnett.setEmail("arnettor@lcc.ufcg.edu.br"));
		assertEquals("arnettor@lcc.ufcg.edu.br", arnett.getEmail());
	}

}
