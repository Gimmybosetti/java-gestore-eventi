package org.generation.italy.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int postiTotali, numPrenotazioni, numCancellazioni;
		LocalDate data;
		String titolo, dataStringa, siNo;
		boolean crea;
		
		do {			
			System.out.println("Inserisci il titolo dell'evento: ");
			titolo = scan.nextLine();
			System.out.println("Qaunti posti sono disponibili per questo evento?");
			postiTotali = scan.nextInt();
			scan.nextLine();
			System.out.println("Quando si terr� l'evento? formato: yyyy-mm-gg");
			dataStringa = scan.nextLine();
			data = LocalDate.parse(dataStringa);
			
			try {
				Evento ev = new Evento(titolo, data, postiTotali);
				System.out.println("Vuoi effettuare delle prenotazioni? Se s�, indicare direttamente il numero "     //siccome il dato boolean della scelta non viene poi riutilizzato evito un 
						+ "di prenotazioni, altrimenti scrivere 0 (posti disponibili = " + ev.postiRimasti() +"):"); //passaggio e unisco la richiesta di prenotazione e il numero di prenotazioni
				numPrenotazioni = scan.nextInt();
				while(numPrenotazioni > 0) {
					ev.prenota();
					numPrenotazioni--;
				}
				System.out.println("Posti prenotati: " + ev.getPostiPrenotati() + "\nPosti liberi: " + ev.postiRimasti());
				System.out.println("Vuoi disdire qualche prenotazione? Se s�, indicare direttamente il numero "
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
			
			System.out.println("\nVuoi creare un nuovo evento? (si/no)");
			scan.nextLine();
			siNo = scan.nextLine();
			
			if(siNo.equalsIgnoreCase("si")) {
				crea = true;
			}else {
				crea = false;
			}
		}while(crea);
		
		scan.close();
	}
	
	
	
	

}
