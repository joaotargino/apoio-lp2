package util;

import java.util.Scanner;

/**
 * Classe de apoio
 * @author Joao Paulo
 * @author Jessica Priscila
 * @author Erickson Filipe
 * @author Arnett Rufino
 *
 */
public class IO {
	
	public static final String NOVA_LINHA = System.getProperty("line.separator");
	public static Scanner scan = new Scanner(System.in);

	/**
	 * cria um numero inteiro valido
	 * @return retorna um numero inteiro valido
	 */
	static int recebeInteiro() {
		while (!scan.hasNextInt()) {
			scan.next();
			System.out.println("INFORME UM NÚMERO INTEIRO: ");

		}
		int inteiro = scan.nextInt();
		scan.nextLine();
		return inteiro;
	}

	/**
	 * cria um numero double valido
	 * @return retorna um double valido
	 */
	static double recebeDouble() {
		while (!scan.hasNextDouble()) {
			scan.next();
			System.out.println("INFORME UM NÚMERO DOUBLE: ");

		}
		double numero = scan.nextDouble();
		scan.nextLine();
		return numero;
	}

	public static String recebeDados(String msg) {
		System.out.print(msg);
		String dado = scan.nextLine().trim();
		while (dado.isEmpty()) {
			System.out.print(msg);
			dado = scan.nextLine().trim();
		}
		return dado;
	}

	public static String recebeDados(String msg, String dadoAntigo) {
		System.out.print(msg);
		String dado = scan.nextLine().trim();
		if (dado.isEmpty()) {
			dado = dadoAntigo;
		}
		return dado;
	}

	


}
