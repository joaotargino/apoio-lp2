package interfaceUsuario;

import java.util.Scanner;

public class Entrada {
	
	static final String NOVA_LINHA = System.getProperty("line.separator");
	static Scanner scan = new Scanner(System.in);

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

	


}
