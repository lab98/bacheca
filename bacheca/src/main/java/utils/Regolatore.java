/**
 * 
 */
package utils;

import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Avviso;
import models.Utente;

/**
 * @author lucalabarbera
 *
 */

/** metodo per il logout dalla sessione **/

public class Regolatore implements Comparator<Avviso> {

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

	@Override
	public int compare(Avviso o1, Avviso o2) {
		return o2.getLivello().compareTo(o1.getLivello());
	}
}
