package org.generation.italy.event;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int postiTotali, numPrenotazioni, numCancellazioni;
		LocalDate data;
		String titolo = "", dataStringa;
		
		System.out.println("Inserisci il titolo dell'evento: ");
		titolo = scan.nextLine();
		System.out.println("Qaunti posti sono disponibili per questo evento?");
		postiTotali = scan.nextInt();
		scan.nextLine();
		System.out.println("Quando si terrà l'evento? formato: yyyy-mm-gg");
		dataStringa = scan.nextLine();
		data = LocalDate.parse(dataStringa);
		
		try {
			Evento ev = new Evento(titolo, data, postiTotali);
			System.out.println("Vuoi effettuare delle prenotazioni? Se sì, indicare direttamente il numero "
					+ "di prenotazioni, altrimenti scrivere 0 (posti disponibili = " + ev.postiRimasti() +"):");
			numPrenotazioni = scan.nextInt();
			while(numPrenotazioni > 0) {
				ev.prenota();
				numPrenotazioni--;
			}
			System.out.println("Posti prenotati: " + ev.getPostiPrenotati() + "\nPosti liberi: " + ev.postiRimasti());
			System.out.println("Vuoi disdire qualche prenotazione? Se sì, indicare direttamente il numero "
					+ "di prenotazioni da disdire, altrimenti scrivere 0:");
			numCancellazioni = scan.nextInt();
			while(numCancellazioni > 0) {
				ev.disdici();
				numCancellazioni--;
			}
			System.out.println("Posti prenotati: " + ev.getPostiPrenotati() + "\nPosti liberi: " + ev.postiRimasti());
		}catch (Exception ex) {
			System.out.print(ex.getMessage());
		}		
		
		scan.close();
	}
	
	
	
	

}
