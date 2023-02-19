package controllers;

import java.io.IOException;

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
 * Servlet implementation class EliminaUser
 */
@WebServlet("/EliminaUser")
public class EliminaUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String basePath = "WEB-INF/VIEWS/";  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			int id = Integer.parseInt(request.getParameter("idUtente"));
			System.out.println(id);
			boolean deleted = Query.eliminaUtente(id);
			if(deleted) {
				response.sendRedirect(request.getContextPath()+"GestioneUtenti");
			}else {
				response.sendRedirect(request.getContextPath()+"ErroreGenerico");
			}
		}catch(Exception e) {
			response.sendRedirect(request.getContextPath()+"/ErroreGenerico");
		}
	}

}
