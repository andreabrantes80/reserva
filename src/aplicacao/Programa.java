package aplicacao;

import java.util.Locale;
import java.util.Scanner;

import entidade.ContaBancaria;
import excecoes.RegraDeNegocio;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		
		System.out.println("Informe od dados da conta: ");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		System.out.print("Titular: ");
		sc.nextLine(); //consumir o buffer
		String titular = sc.nextLine();
		System.out.print("Saldo Inicial: ");
		double saldo = sc.nextDouble();
		System.out.print("Limite de saque: ");
		double limiteSaque = sc.nextDouble();
		
		ContaBancaria cc = new ContaBancaria(numero, titular, saldo, limiteSaque);
		
		System.out.println();
		System.out.print("Informe uma quantia para saque:R$ ");
		double quantia = sc.nextDouble();
		
		
		try {
			cc.saque(quantia);
			System.out.println("Novo Saldo: R$ " + String.format("%.2f", cc.getSaldo()));			
		}
		catch(RegraDeNegocio e) {
			System.out.println(e.getMessage());
		}
		
		
		sc.close();

	}

}
