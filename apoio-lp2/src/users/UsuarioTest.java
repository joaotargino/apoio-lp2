package users;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class UsuarioTest {
	
	public class Usr extends Usuario{
		public Usr(String login, String senha, String nome, String email) throws Exception {
			super(login, senha, nome, email);
		}
	}
	private Usuario erickson;
	private Usuario arnett;

	@Before
	public void setUp() throws Exception {
		erickson = new Usr("20821200", "123456", "Erickson", "ericksonfilipe@gmail.com");
		arnett = new Usr("20821209", "123456", "Arnett", "shrivelfigs@gmail.com");
	}
	
	@Test(expected=Exception.class)
	public void ConstrutorTest() throws Exception {
		Usuario pessoa = new Usr(null, "coisi", "coisaosi", "a@g.c");
	}
	
	@Test(expected=Exception.class)
	public void Construtor2Test() throws Exception {
		Usuario pessoa = new Usr("055", "coisi", "coisaosi", "a@g.c");
	}
	
	@Test(expected=Exception.class)
	public void Construtor3Test() throws Exception {
		Usuario pessoa = new Usr("20821200", "123", "coisaosi", "a@g.c");
	}
	
	@Test(expected=Exception.class)
	public void Construtor4Test() throws Exception {
		Usuario pessoa = new Usr("20821200", "123456", "coisaosi", "a@gc");
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
	
	//Teste de Metodo da Classe Sistema
	@Test
	public void mandaSenhaPorEmailTest() {
		assertTrue(Usuario.mandaSenhaPorEmail("20821200"));
		assertFalse(Usuario.mandaSenhaPorEmail("20821"));
	}

}
