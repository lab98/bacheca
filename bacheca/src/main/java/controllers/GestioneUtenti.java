package controllers;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Messaggio;
import models.Utente;
import utils.Query;

/**
 * Servlet implementation class GestioneUtenti
 */
@WebServlet("/GestioneUtenti")
public class GestioneUtenti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String basePath = "WEB-INF/VIEWS/";  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneUtenti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			LinkedList<Utente> utenti = Query.getUtentiFromTipo(false);
			System.out.println(utenti);
			session.setAttribute("listaUtenti", utenti);
			
			/*
			 * String message ="Lista  User Aggiornata "; Messaggio m = new
			 * Messaggio(1,"gestioneUtenti",message); session.setAttribute("messaggio", m);
			 */
			
			
			/*
			 * RequestDispatcher dispatcher =
			 * request.getRequestDispatcher(basePath+"header.jsp");
			 * dispatcher.include(request, response); dispatcher =
			 * request.getRequestDispatcher(basePath+"navbarAdmin.jsp");
			 * dispatcher.include(request, response); dispatcher =
			 * request.getRequestDispatcher(basePath+"gestioneUtenti.jsp");
			 * dispatcher.include(request, response); dispatcher =
			 * request.getRequestDispatcher(basePath+"footer.jsp");
			 * dispatcher.include(request,response);
			 */
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"gestioneUtenti.jsp");
			dispatcher.include(request, response);
			
			
		}catch(Exception e) {
			response.sendRedirect(request.getContextPath()+"/AdminPage");
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
