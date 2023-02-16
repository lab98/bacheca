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
	private String token;
	private boolean valid;
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
			String password, String token, boolean valid) {
		this.idUtente = idUtente;
		this.nome = nome;
		this.cognome = cognome;
		this.ruolo = ruolo;
		this.tipo = tipo;
		this.email = email;
		this.password = password;
		this.token = token;
		this.valid = valid;
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
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	
}
