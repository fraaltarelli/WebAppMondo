package it.objectmethod.webappMondo.model;

public class Citta {

	private int id;
	private String nomeCitta;
	private String distretto;
	private int popolazione;
	private String countryCode;

	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDistretto() {
		return distretto;
	}
	public void setDistretto(String distretto) {
		this.distretto = distretto;
	}

	public String getNomeCitta() {
		return nomeCitta;
	}
	public void setNomeCitta(String nomeCitta) {
		this.nomeCitta = nomeCitta;
	}
	public int getPopolazione() {
		return popolazione;
	}
	public void setPopolazione(int popolazione) {
		this.popolazione = popolazione;
	}

}
