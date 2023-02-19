package controllers;

import java.io.IOException;

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
 * Servlet implementation class ModificaAvviso
 */
@WebServlet("/ModificaAvviso")
public class ModificaAvviso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String basePath = "WEB-INF/VIEWS/";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaAvviso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			int id = Integer.parseInt(request.getParameter("idAvviso"));
			System.out.println(id);
			Avviso avviso = Query.getAvvisoFromId(id);
			session.setAttribute("avvisomod", avviso);
			RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"header.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"navbarAdmin.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"modificaAvviso.jsp");
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
			System.out.println("ModificaAvviso");
			int id = Integer.parseInt(request.getParameter("idAvviso"));
			String titolo = request.getParameter("titolo");
			String testo = request.getParameter("testo");
			String datascad = request.getParameter("datascad");
			String livello = request.getParameter("livello");
			
			boolean update = Query.modificaAvviso(id, livello, datascad, testo, titolo);
			if(update) {
				response.sendRedirect(request.getContextPath()+"ModificaAvviso?idUtente="+id);
			}else {
				response.sendRedirect(request.getContextPath()+"ErroreGenerico");
			}
		}catch(Exception e) {
			
		}
	}

}
