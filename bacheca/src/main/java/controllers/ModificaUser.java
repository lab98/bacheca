package controllers;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Utente;
import utils.Query;

/**
 * Servlet implementation class ModificaUser
 */
@WebServlet("/ModificaUser")
public class ModificaUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String basePath = "WEB-INF/VIEWS/";  
    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			int id = Integer.parseInt(request.getParameter("idUtente"));
			System.out.println(id);
			Utente utente = Query.getUtenteFromId(id);
			session.setAttribute("modificato", utente);
			RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"header.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"navbarAdmin.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"modificaUser.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"footer.jsp");
			dispatcher.include(request,response);
		}catch(Exception e) {
			response.sendRedirect(request.getContextPath()+"/ErroreGenerico");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			System.out.println("ModificaUser");
			int id = Integer.parseInt(request.getParameter("idUtente"));
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String email = request.getParameter("email");
			String ruolo = request.getParameter("ruolo");
			System.out.println(id + nome + cognome + email + ruolo);
			boolean update = Query.modificaUtente(id, nome, cognome, email, ruolo);
			if(update) {
				response.sendRedirect(request.getContextPath()+"ModificaUser?idUtente="+id);
			}else {
				response.sendRedirect(request.getContextPath()+"ErroreGenerico");
			}
		}catch(Exception e) {
			
		}
	}

}
