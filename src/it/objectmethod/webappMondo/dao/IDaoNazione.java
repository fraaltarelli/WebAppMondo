package it.objectmethod.webappMondo.dao;

import java.util.List;

import it.objectmethod.webappMondo.model.Nazione;

public interface IDaoNazione {

	public List<String> getAllContinents();
	public List<Nazione> getAllNationsByContinent(String continent);
	public List<String> allNationNames();
	
}
