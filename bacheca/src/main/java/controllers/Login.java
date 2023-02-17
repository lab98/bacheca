package controllers;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Query;
import models.Messaggio;
import models.Utente;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String basePath = "WEB-INF/VIEWS/";   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
    	
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"navbar.jsp");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher(basePath+"login.jsp");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher(basePath+"footer.jsp");
		dispatcher.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			System.out.println(email+password);
			HttpSession session = request.getSession();	
			Utente utente = Query.accedi(email, password);
			if(utente.getIdUtente()!=0) {
				session.setAttribute("utente", utente);
				response.sendRedirect(request.getContextPath()+"/UserPage");
			
				}else {
					System.out.println("Pass errata");
            		String message = "Username o Password errata!";
            		Messaggio m= new Messaggio(0,"login", message);
            		session.setAttribute("messaggio", m);
            		System.out.println(request.getContextPath());
            		response.sendRedirect(request.getContextPath()+"/Login");
				}
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				response.sendRedirect(request.getContextPath()+"/ErroreGenerico");
			}

	}
}
