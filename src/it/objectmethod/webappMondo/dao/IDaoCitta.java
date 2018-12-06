package it.objectmethod.webappMondo.dao;

import java.util.List;

import it.objectmethod.webappMondo.model.Citta;

public interface IDaoCitta {
	
	 public List<Citta> getAllCitiesByNation(String countrycode);
	 public List<Citta> cercaCitta(String cittaCercata);
	 public void eliminaCitta(int idCitta);
	 public void modificaCitta(int idCittaDaModificare, String nome, String distretto, int popolazione);
	 public void inserisciCitta(String nazione, String nome, String distretto, int popolazione);
	 public Citta cittaDaModificare(int id);
	

}
