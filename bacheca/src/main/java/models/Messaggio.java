/**
 * 
 */
package models;

/**
 * @author lucalabarbera
 *
 */
public class Messaggio {
	
	private int codice; //0: Errore, 1:Successo, 2:Avviso
	private String jsp; // nome della jsp che deve gestirlo
	private String testo; // testo del messaggio di errore
	//da usare per ritornare messaggi
	public Messaggio() {};
	
	public Messaggio(int codice, String jsp, String testo) {
		setCodice(codice);
		setJsp(jsp);
		setTesto(testo);
	}
	
	public int getCodice() {
		return this.codice;
	}
	
	public String getJsp() {
		return this.jsp;
	}
	
	public String getTesto() {
		return this.testo;
	}
	
	public void setCodice(int c) {
		if(c==0||c==1||c==2) {
		this.codice=c;
		}
		else {
			this.codice=0;
		}
	}
	public void setJsp(String s) {
		this.jsp=s;
	}
	public void setTesto(String t) {
		this.testo=t;
	}

}
