package models;

public class Allegato {

	private int idAllegato;
	private int idAvviso;
	private String percorso;
	/**
	 * @param idAllegato
	 * @param idAvviso
	 * @param percorso
	 */
	public Allegato(int idAllegato, int idAvviso, String percorso) {
		this.idAllegato = idAllegato;
		this.idAvviso = idAvviso;
		this.percorso = percorso;
	}
	/**
	 * 
	 */
	public Allegato() {
	}
	public int getIdAllegato() {
		return idAllegato;
	}
	public void setIdAllegato(int idAllegato) {
		this.idAllegato = idAllegato;
	}
	public int getIdAvviso() {
		return idAvviso;
	}
	public void setIdAvviso(int idAvviso) {
		this.idAvviso = idAvviso;
	}
	public String getPercorso() {
		return percorso;
	}
	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}
	
	
}