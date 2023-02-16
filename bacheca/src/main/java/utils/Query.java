/**
 * 
 */
package utils;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import javax.naming.NamingException;

import models.*;

/**
 * @author lucalabarbera
 *
 */
/* classe contenente tutte le query da effettuare*/

public class Query {

	private static ConnessioneDB connessione = new ConnessioneDB();
	private static PreparedStatement statement;
	
	
	/*** Stringhe Query per Utente***/
	
	private static String registrazioneQuery = "INSERT INTO utente (nome, cognome,tipo, ruolo, email, password) VALUES (?,?,?,?,?,?)";	
	private static String loginQuery = "SELECT * FROM utente WHERE email = ?";
	private static String getUtenteFromTokenQuery="SELECT * FROM utente WHERE token = ?";
	private static String modificaUtenteQuery ="UPDATE utente SET nome =?, cognome=?, ruolo=? WHERE id_utente=? ";
	private static String eliminaUtenteQuery ="DELETE FROM utente WHERE id_utente=?";
	private static String listaUtentiQuery ="SELECT * FROM utente";
	private static String setPasswordUtenteQuery ="UPDATE utente SET password=? WHERE email=?";
	private static String setTokenQuery="UPDATE utente SET token =?, valid=? WHERE email=?";
	private static String getUtenteFromIdQuery="SELECT * FROM utente WHERE id_utente = ?";
	
	/*** Stringhe query Avviso ***/
	
	private static String aggiungiAvvisoQuery = "INSERT INTO avviso (idutente, livello, datapub, datamod, datascad, testo) VALUES (?,?,?,?,?,?)";
	private static String modificaAvvisoQuery = "UPDATE avviso SET livello=?, datamod=?, datascad=?, testo=? WHERE idavviso=?";
	private static String eliminaAvvisoQuery = "DELETE FROM avviso WHERE idavviso=?";
	private static String getListaAvvisiUtenteQuery = "SELECT * FROM avviso WHERE idutente=?";
	private static String getAvvisiValidiQuery = "SELECT * FROM avviso WHERE datasca>=?";
	
	
	/*** Stringhe query Allegati ***/
	
	private static String aggiungiAllegatoQuery="INSERT INTO allegato (idallegato, idavviso, percorso) VALUES (?,?,?)";
	private static String rimuoviAllegatoQuery="DELETE FROM allegato WHERE idallegato=?";
	private static String getAllegatiAvvisoQuery ="SELECT * FROM allegato WHERE idavviso=?";
	
	/*** Metodo per hashing ***/
			
	public static String hashPassword(String password) throws NoSuchAlgorithmException {
		
		MessageDigest msgDgst = MessageDigest.getInstance("SHA-256");
		byte[] hash = msgDgst.digest(password.getBytes(StandardCharsets.UTF_8));
		BigInteger no = new BigInteger(1, hash);
		StringBuilder hexStr = new StringBuilder(no.toString(16)); 
		while (hexStr.length() < 32){  
		hexStr.insert(0, '0');  
		}  
		return hexStr.toString(); 	
	}
	
	/*** query tabella utente ***/
	public static Utente getUtenteFromId(int id) throws NamingException, SQLException {
		Connection cn= connessione.apriConnessione();
		statement = cn.prepareStatement(getUtenteFromIdQuery);
		statement.setInt(1, id);
		statement.executeQuery();
		ResultSet res = statement.getResultSet();
		Utente utente = new Utente();
		if(res.next()) {
			utente.setIdUtente(res.getInt("idutente"));
			utente.setNome(res.getString("nome"));
			utente.setCognome(res.getString("cognome"));
			utente.setEmail(res.getString("email"));
			utente.setPassword(res.getString("password"));
			utente.setRuolo(res.getString("ruolo"));
			utente.setToken(res.getString("token"));
			utente.setValid(res.getBoolean("valid"));
			utente.setTipo(res.getBoolean("tipo"));
		}
		cn.close();
		return utente;
	}
	
	public static boolean setPasswordUtente(String email, String password) throws NamingException, SQLException, NoSuchAlgorithmException {
		
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(setPasswordUtenteQuery);
		statement.setString(1, hashPassword(password));
		statement.setString(2, email);
		statement.executeUpdate();
		cn.close();
		return true;
		
	}
	
	public static boolean isUtente(String email) throws NamingException, SQLException {
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(loginQuery);
		statement.setString(1, email);
		statement.executeQuery();
		ResultSet res = statement.getResultSet();
		if(res.next()) {
			cn.close();
			return true;
		}
		cn.close();
		return false;
	}
	
	public static Utente getUtenteFromToken(String token) throws NamingException, SQLException {
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(getUtenteFromTokenQuery);
		statement.setString(1, token);
		statement.executeQuery();
		ResultSet res =statement.getResultSet();
		Utente utente = new Utente();
		if(res.next()) {
			utente.setIdUtente(res.getInt("idutente"));
			utente.setNome(res.getString("nome"));
			utente.setCognome(res.getString("cognome"));
			utente.setEmail(res.getString("email"));
			utente.setPassword(res.getString("password"));
			utente.setRuolo(res.getString("ruolo"));
			utente.setToken(res.getString("token"));
			utente.setValid(res.getBoolean("valid"));
			utente.setTipo(res.getBoolean("tipo"));
		}
		cn.close();
		return utente;
	}
	
	public static String setToken(String email, boolean valid) throws NoSuchAlgorithmException, NamingException, SQLException {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String token = hashPassword(email+timestamp.toString());
		token = token.substring(0, 30);
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(setTokenQuery);
		statement.setString(1, token);
		statement.setBoolean(2, valid);
		statement.setString(3, email);
		statement.executeUpdate();
		cn.close();
		return token;
	}
	
	public static Utente accedi(String email, String password) throws NamingException, SQLException, NoSuchAlgorithmException {
		
		String hashPassw =hashPassword(password);
		Connection cn = connessione.apriConnessione();
		String query=loginQuery;
		statement= cn.prepareStatement(query);
		statement.setString(1, email);
		statement.executeQuery();
		ResultSet res = statement.getResultSet();
		Utente utente = new Utente();
		if(res.next()) {
			if(res.getString("password").equals(hashPassw)) {
				utente.setIdUtente(res.getInt("idutente"));
				utente.setNome(res.getString("nome"));
				utente.setCognome(res.getString("cognome"));
				utente.setEmail(res.getString("email"));
				utente.setPassword(res.getString("password"));
				utente.setRuolo(res.getString("ruolo"));
				utente.setToken(res.getString("token"));
				utente.setValid(res.getBoolean("valid"));
				utente.setTipo(res.getBoolean("tipo"));
				}
		}
		cn.close();
		return utente;
		
	}
	
	public static boolean registrazione(String nome, String cognome, String email, String password, String ruolo, boolean tipo ) throws NamingException, SQLException, NoSuchAlgorithmException {
		
		Connection cn = connessione.apriConnessione();
		String query = registrazioneQuery;
		statement= cn.prepareStatement(query);
		PreparedStatement stat = cn.prepareStatement(loginQuery);
		stat.setString(1, email);
		stat.executeQuery();
		ResultSet resLogin = stat.getResultSet();
		if(!resLogin.next()) {
			statement.setString(1,nome);
			statement.setString(2,cognome);
			statement.setBoolean(3, tipo);
			statement.setString(4, ruolo);
			statement.setString(5,email);
			statement.setString(6,hashPassword(password));
			statement.executeUpdate();
			cn.close();
			return true;
		}else
			cn.close();
			return false ;   /* se è già presente un utente con quella mail allora il metodo 
								di registrazione torna false e segnala che esiste già un account associato alla email*/
	}
	
	public static boolean eliminaUtente(int idutente) throws NamingException, SQLException {
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(eliminaUtenteQuery);
		statement.setInt(1, idutente);
		statement.executeUpdate();
		cn.close();	
		return true;
		
	}
	
	/*** Query tabella Avviso  ***/
	public static boolean aggiungiAvviso(int idutente, String livello,String datascad,String testo) throws NamingException, SQLException {
		Connection cn = connessione.apriConnessione();
		String query = aggiungiAvvisoQuery;
		PreparedStatement stat = cn.prepareStatement(query);
		stat.setInt(1, idutente);
		stat.setString(2, livello);
		stat.setDate(3, Date.valueOf(java.time.LocalDate.now().toString()));
		stat.setDate(4, Date.valueOf(java.time.LocalDate.now().toString()));
		stat.setDate(5, Date.valueOf(datascad));
		stat.setString(6, testo);
		stat.executeUpdate();
		cn.close();
		return true;
		
	}
	
	public static boolean eliminaAvviso(int idavviso) throws NamingException, SQLException {
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(eliminaAvvisoQuery);
		statement.setInt(1, idavviso);
		statement.executeUpdate();
		cn.close();	
		return true;
		
	}
	
	public static boolean modificaAvviso(int idavviso, String livello, String datascad, String testo) throws SQLException, NamingException {
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(modificaAvvisoQuery);
		statement.setString(1, livello);
		statement.setDate(2, Date.valueOf(java.time.LocalDate.now().toString()));
		statement.setDate(3, Date.valueOf(datascad));
		statement.setString(5, testo);
		statement.setInt(6, idavviso);
		statement.executeUpdate();
		cn.close();
		
		
		return true;
		
	}
	
	public static LinkedList<Avviso> getListaAvvisiUtente(int idutente) throws SQLException, NamingException{
		LinkedList<Avviso> avvisi = new LinkedList<Avviso>();
		
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(getListaAvvisiUtenteQuery);
		statement.setInt(1, idutente);
		statement.executeQuery();
		ResultSet res = statement.getResultSet();
		while(res.next()) {
			Avviso avviso = new Avviso();
			avviso.setIdAvviso(res.getInt("idavviso"));
			avviso.setDataPub(res.getDate("datapub").toString());
			avviso.setDataMod(res.getDate("datamod").toString());
			avviso.setDataScad(res.getDate("datascad").toString());
			avviso.setIdUtente(idutente);
			avviso.setLivello(res.getString("livello"));
			avviso.setTesto(res.getString("testo"));
			
			avvisi.add(avviso);
		}
		
		cn.close();
		return avvisi;
	}
	
	public static LinkedList<Avviso> getAvvisiValidi() throws SQLException, NamingException{
		LinkedList<Avviso> avvisi = new LinkedList<Avviso>();
		
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(getAvvisiValidiQuery);
		statement.setDate(1, Date.valueOf(java.time.LocalDate.now().toString()));
		statement.executeQuery();
		ResultSet res = statement.getResultSet();
		while(res.next()) {
			Avviso avviso = new Avviso();
			avviso.setIdAvviso(res.getInt("idavviso"));
			avviso.setDataPub(res.getDate("datapub").toString());
			avviso.setDataMod(res.getDate("datamod").toString());
			avviso.setDataScad(res.getDate("datascad").toString());
			avviso.setIdUtente(res.getInt("idutente"));
			avviso.setLivello(res.getString("livello"));
			avviso.setTesto(res.getString("testo"));
			
			avvisi.add(avviso);
		}
		
		cn.close();
		return avvisi;
	}
	
	
	public static boolean aggiungiAllegato(int idallegato, int idavviso, String percorso) throws NamingException, SQLException {
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(aggiungiAllegatoQuery);
		statement.setInt(1, idallegato);
		statement.setInt(2, idavviso);
		statement.setString(3, percorso);
		statement.executeUpdate();
		cn.close();
		return true;
	}
	
	public static boolean rimuoviAllegato(int idallegato) throws NamingException, SQLException {
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(rimuoviAllegatoQuery);
		statement.setInt(1, idallegato);
		statement.executeUpdate();
		cn.close();
		return true;
	}
	
	public static LinkedList<Allegato> getAllegatiAvviso(int idavviso) throws NamingException, SQLException{
		Connection cn = connessione.apriConnessione();
		statement = cn.prepareStatement(getAllegatiAvvisoQuery);
		
		LinkedList<Allegato> allegati = new LinkedList<Allegato>();
		
		statement.setInt(1, idavviso);
		
		statement.executeQuery();
		ResultSet res = statement.getResultSet();
		while(res.next()) {
			Allegato allegato = new Allegato();
			allegato.setIdAllegato(res.getInt("idallegato"));
			allegato.setIdAvviso(idavviso);
			allegato.setPercorso(res.getString("percorso"));
			
			allegati.add(allegato);
		}
		cn.close();
		return allegati;
	}
}
