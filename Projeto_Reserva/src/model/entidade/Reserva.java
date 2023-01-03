package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.excecoes.DomainExcecoes;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) throws DomainExcecoes {
		if(!checkOut.after(checkIn)){
			throw new DomainExcecoes("Erro: a data de check-out deve ser posterior à data de check-in");
		}		
		
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}


	public Date getCheckOut() {
		return checkOut;
	}
	
	//calcula a duração em dias 
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void atualizacaoData(Date checkIn, Date checkOut) throws DomainExcecoes {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainExcecoes("Erro: Reservas informar datas futuras.");
		}
		if(!checkOut.after(checkIn)){
			throw new DomainExcecoes("Erro: a data de check-out deve ser posterior à data de check-in");
		}		
		this.checkIn = checkIn;
		this.checkOut = checkOut;		
	}
	
	@Override
	public String toString() {
		return "Quarto "
				+numeroQuarto
				+", check-In: "
				+sdf.format(checkIn)
				+", check-Out: "
				+sdf.format(checkOut)
				+", "
				+duracao()
				+" Noites";
	}

	
	
	
	
}
