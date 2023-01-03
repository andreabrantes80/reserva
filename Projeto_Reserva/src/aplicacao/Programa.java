package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;
import model.excecoes.DomainExcecoes;

public class Programa {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	try {
		
		System.out.print("Digite o numero do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data do Check-In (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-Out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());		
		
		Reserva reserva = new Reserva(numero, checkIn, checkOut);
		System.out.println("Reserva: " + reserva);
		
		System.out.println();
		System.out.println("Entre com a nova data da reserva: ");
		System.out.print("Data do Check-In (dd/MM/yyyy): ");
		checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-Out (dd/MM/yyyy): ");
		checkOut = sdf.parse(sc.next());		

		reserva.atualizacaoData(checkIn, checkOut);
		System.out.println("Reserva: " + reserva);
	}
	catch(ParseException e) {
		System.out.println("Data invalida: ");
	}
	catch(DomainExcecoes e) {
		System.out.println("Erro na reserva " +e.getMessage());
	}
	catch(RuntimeException e) {
		System.out.println("Erro inesperado!");
	}
		
		System.out.println();
		System.out.println();
	
		
		sc.close();

	}

}
