package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Digite o numero do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data do Check-In (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do Check-Out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro: a data de check-out deve ser posterior à data de check-in");
		}else {
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
			System.out.println();
		}
		
		sc.close();

	}

}
