package testes;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controle.BD;
import static org.junit.Assert.*;

import disciplina.Exercicio;

public class ExercicioTest {
	
	Exercicio ex;
	GregorianCalendar data;
	List questoes;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setUp() {
		data = new GregorianCalendar(2010, 9, 15);
		questoes = new ArrayList<String>();
		BD.resetExercicios();
		try {
			ex = new Exercicio("nome", "descricao", data, questoes);
			BD.cadastraExercicio(ex);
		} catch (Exception e) {
			fail("O exercicio deveria ter sido criado!");
		}
	}
	
	@After
	public void tearDown() {
		BD.removeExercicio(ex.getId());
	}
	
	@Test
	public void construtorTest() {
		try {
			new Exercicio(null, "descricao", data, questoes);
			fail("O nome do exercicio n�o pode ser nulo!");
		} catch (Exception e) {
		}
		
		try {
			new Exercicio("nome", null, data, questoes);
			fail("A descric�o do exercicio n�o pode ser nula!");
		} catch (Exception e) {
		}
		
		try {
			new Exercicio("nome", "descric�o", null, questoes);
			fail("A data do exercicio n�o pode ser nula!");
		} catch (Exception e) {
		}
	}

	@Test
	public void setNomeSoEspacoTest() {
		try {
			ex.setNome("        ");
			fail("Um exerc�cio n�o pode ter um nome s� composto por espa�os!");
		} catch (Exception e) {
		}
	}

}
