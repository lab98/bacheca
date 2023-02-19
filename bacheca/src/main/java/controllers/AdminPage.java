package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Messaggio;
import utils.Query;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/AdminPage")
public class AdminPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String basePath = "WEB-INF/VIEWS/";  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"header.jsp");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher(basePath+"navbarAdmin.jsp");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher(basePath+"aggiungiUtente.jsp");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher(basePath+"footer.jsp");
		dispatcher.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession sessione = request.getSession();
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String ruolo = request.getParameter("ruolo");
			String tipoS = request.getParameter("tipo");
			boolean tipo=false;
			if(tipoS.equals("admin")) {
				tipo=true;
			}
			System.out.println(nome+cognome+email+password+ruolo+tipo);
			boolean registered = Query.registrazione(nome, cognome, email, password, ruolo, tipo);
			if(registered) {
				String message="Utente Registrato con successo";
				Messaggio m = new Messaggio(1,"aggiungiUtente",message);
				sessione.setAttribute("messaggio",m);
				response.sendRedirect(request.getContextPath()+"/AdminPage");
			}else {
				String message="Utente Non Registrato, Errore!";
				Messaggio m = new Messaggio(0,"aggiungiUtente",message);
				sessione.setAttribute("messaggio",m);
				response.sendRedirect(request.getContextPath()+"/AdminPage");
			}
		}catch(Exception e) {response.sendRedirect(request.getContextPath()+"/ErroreGenerico");}
	}

}
