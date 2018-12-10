package it.objectmethod.webappMondo.dao;

import java.util.List;

import it.objectmethod.webappMondo.model.Citta;

public interface IDaoCitta {
	
	 public List<Citta> getAllCitiesByNation(String countrycode);
	 public List<Citta> cercaCitta(String cittaCercata);
	 public void eliminaCitta(int idCitta);
	 public void aggiornaCitta(Citta cittaDaAggiornare);
	 public void inserisciCitta(Citta cittaDaInserire);
	 public Citta cittaDaModificare(int id);
	

}
