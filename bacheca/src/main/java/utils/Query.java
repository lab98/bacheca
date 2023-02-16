/**
 * 
 */
package utils;

import java.sql.PreparedStatement;
import models.*;

/**
 * @author lucalabarbera
 *
 */
/* classe contenente tutte le query da effettuare*/

public class Query {

	private static ConnessioneDB connessione = new ConnessioneDB();
	private static PreparedStatement statement;
	
	private static String registrazioneQuery = "INSERT INTO utente (nome, cognome,tipo, ruolo, email, password) VALUES (?,?,?,?,?,?)";	
	private static String loginQuery = "SELECT * FROM utente WHERE email = ?";
	private static String getUtenteFromTokenQuery="SELECT * FROM utente WHERE token = ?";
	
}
