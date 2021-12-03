package org.generation.italy.event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammEvent {
	
	//attributi
	private String titolo;
	private List<Evento> listaEventi;
	
	//costruttore
	public ProgrammEvent (String titolo) {
		this.titolo = titolo;
		listaEventi = new ArrayList<Evento>();
	}
	
	//getter e setter
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Evento> getListaEventi() {
		return listaEventi;
	}

	public void setListaEventi(List<Evento> listaEventi) {
		this.listaEventi = listaEventi;
	}

	//metodi
	public List<Evento> aggiungiEvento (Evento ev){
		listaEventi.add(ev);
		return listaEventi;
	}
	
	public int contaEventi (ArrayList<Evento> listaEventi) {
		return listaEventi.size();
	}
	
	public List<Evento> eventiInData (LocalDate data){
		ArrayList<Evento> eventiDataPrecisa = new ArrayList<Evento>();
		for(Evento ev : listaEventi) {
			if(ev.getData().isEqual(data)) {
				eventiDataPrecisa.add(ev);
			}
		}
		return eventiDataPrecisa;
	}
	
	public void svuotaLista () {
		listaEventi.clear();
	}

	public String eventiOrdinati () {
		String stringaOrdinata = "";
		List<Evento> listaOrdinata = new ArrayList<Evento>();
		Collections.sort(getListaEventi());
		listaOrdinata = getListaEventi();
		for(Evento ev : listaOrdinata) {
			stringaOrdinata += ev.getData().toString() + "\n";
		}
		return stringaOrdinata;
		
		
	}
	
}
