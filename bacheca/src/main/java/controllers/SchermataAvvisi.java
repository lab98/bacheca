package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Avviso;
import utils.Query;
import utils.Regolatore;

/**
 * Servlet implementation class SchermataAvvisi
 */
@WebServlet("/SchermataAvvisi")
public class SchermataAvvisi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String basePath = "WEB-INF/VIEWS/";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchermataAvvisi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			System.out.println("SchermataAvvisi");
			LinkedList<Avviso> listaAvvisi= Query.getAvvisiValidi();
			
			Collections.sort(listaAvvisi, new Regolatore());
			session.setAttribute("avvisiValidi", listaAvvisi);
			RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"header.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"navbar.jsp");
			dispatcher.include(request, response);
			
			//dispatcher = request.getRequestDispatcher(basePath+"schermataAvvisi.jsp");
			dispatcher = request.getRequestDispatcher(basePath+"SchermataAvvisi_NEW.jsp");
			
			dispatcher.include(request, response);
			/*
			 * dispatcher = request.getRequestDispatcher(basePath+"footer.jsp");
			 * dispatcher.include(request,response);
			 */
		}catch(Exception e) {
			response.sendRedirect(request.getContextPath()+"/ErroreGenerico");
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
