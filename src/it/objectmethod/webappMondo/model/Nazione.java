package it.objectmethod.webappMondo.model;

public class Nazione {
	
	private String code;
	private String nomeNazione;
	public int popolazione;

	public int getPopolazione() {
		return popolazione;
	}

	public void setPopolazione(int popolazione) {
		this.popolazione = popolazione;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNomeNazione() {
		return nomeNazione;
	}

	public void setNomeNazione(String nomeNazione) {
		this.nomeNazione = nomeNazione;
	}
}
