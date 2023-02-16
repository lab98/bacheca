/**
 * 
 */
package models;

/**
 * @author lucalabarbera
 *
 */
public class Utente {

	private int idUtente;
	private String nome;
	private String cognome;
	private String ruolo;
	private boolean tipo;
	private String email;
	private String password;
	/**
	 * @param idUtente
	 * @param nome
	 * @param cognome
	 * @param ruolo
	 * @param tipo
	 * @param email
	 * @param password
	 */
	public Utente(int idUtente, String nome, String cognome, String ruolo, boolean tipo, String email,
			String password) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.tipo = tipo;
		this.email = email;
		this.password = password;
	}
	public Utente() {
		super();
	}
	public int getIdUtente() {
		return idUtente;
	}
	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public boolean isTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
