package org.generation.italy.event;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento implements Comparable<Evento> {
	
	//attributi
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	
	//costruttore
	public Evento(String titolo, LocalDate data, int postiTotali) throws Exception {
		
		this.titolo = titolo;
		this.postiPrenotati = 0;
		if(isValidDate(data)) {
			this.data = data;
		}else {
			throw new Exception("La data non può essere antecedente a oggi!");
		}
		
		if(isValidPostiTotali()) {
			this.postiTotali = postiTotali;
		}else {
			throw new Exception("Il numero di posti totali deve essere positivo!");
		}
	}
	
	//getter e setter
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}
	
	public int postiRimasti () {
		return getPostiTotali() - getPostiPrenotati();
	}
	
	//metodi di check
	private boolean isValidDate(LocalDate data) {
		return data.isAfter(LocalDate.now());
	}

	private boolean isValidPostiTotali() {
		if (postiTotali < 0) {
			return false;
		}else {
			return true;
		}
	}
	
	//metodi
	public void prenota() throws Exception {
		if(!isValidDate(this.data)) {
			throw new Exception("La data è già passata!");
		}else if (postiPrenotati > postiTotali){
			throw new Exception("Non ci sono abbastanza posti oppure sono terminati");
		}else {
			postiPrenotati++;;
		}
	}
	
	public void disdici() throws Exception {
		if(postiPrenotati == 0) {
			throw new Exception("Non ci sono abbastanza prenotazioni!");
		}else if (!isValidDate(this.data)){
			throw new Exception("La data è già passata!");
		}else {
			postiPrenotati--;
		}
	}

	@Override
	public String toString() {
		String dataFormattata = "";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dataFormattata = data.format(formatter);
		return dataFormattata + " - " + titolo;
	}

	@Override
	public int compareTo(Evento o) {
		int result;
		if(this.getData().isAfter(o.getData())) {
			result = -1;
		}else if(this.getData().isBefore(o.getData())) {
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}
	
	
	
}























