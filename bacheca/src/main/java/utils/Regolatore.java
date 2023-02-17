/**
 * 
 */
package utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Utente;

/**
 * @author lucalabarbera
 *
 */

/** metodo per il logout dalla sessione **/

public class Regolatore {

	public String controlloAccesso(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession();
    	if(session.getAttribute("utente")== null) {
    		System.out.println("utente non presente");
    		return "not"; // vai al Login
    	}
    	else {
    		Utente u = (Utente) session.getAttribute("utente");
    		System.out.println(u.getRuolo()+" accesso effettuato");
    		return "in" ; //vai all'Area riservata
    	}
    }
}
