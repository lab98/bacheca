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

import models.Avviso;
import models.Utente;
import utils.Query;

/**
 * Servlet implementation class GestioneAvvisi
 */
@WebServlet("/GestioneAvvisi")
public class GestioneAvvisi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String basePath = "WEB-INF/VIEWS/";  
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestioneAvvisi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {	
			HttpSession session = request.getSession();
			Utente utente = (Utente) session.getAttribute("utente");
			System.out.println(utente.getIdUtente());
			LinkedList<Avviso> listaAvvisi = Query.getListaAvvisiUtente(utente.getIdUtente());
			session.setAttribute("listaAvvisi", listaAvvisi);
			RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"header.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"navbarUser.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"gestioneAvvisi.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"footer.jsp");
			dispatcher.include(request,response);
			}catch(Exception e) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
