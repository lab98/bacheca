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
import models.Utente;
import utils.Query;

/**
 * Servlet implementation class RecuperoPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String basePath = "WEB-INF/VIEWS/"; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			
			
		HttpSession session = request.getSession();
		Utente utente = (Utente) session.getAttribute("utente");
		if(utente.isTipo()) {
		/*	
			RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"header.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"navbarAdmin.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"resetPassword.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"footer.jsp");
			dispatcher.include(request,response);
			
			*/
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"resetPassword.jsp");
			dispatcher.include(request, response);
			
			
		}else {
			
			/*
			RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"header.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"navbarUser.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"resetPassword.jsp");
			dispatcher.include(request, response);
			dispatcher = request.getRequestDispatcher(basePath+"footer.jsp");
			dispatcher.include(request,response);
			*/
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(basePath+"resetPassword.jsp");
			dispatcher.include(request, response);
			
			
			
		}
		
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
			Utente utente = (Utente) session.getAttribute("utente");
			
			System.out.println("sono RESET PASSWORD l'utente impostato e "+ utente);

			
			String password = request.getParameter("password");
			String confpass= request.getParameter("confirm-password");
			if(password.equals(confpass)) {
				boolean updated = Query.setPasswordUtente(utente.getIdUtente(), password);
				if(updated) {
					String message = "Password Reimpostata Con Successo";
					Messaggio m= new Messaggio(1,"resetPassword",message);
					session.setAttribute("messaggio", m);
					response.sendRedirect(request.getContextPath()+"/ResetPassword");
				}else {
					response.sendRedirect(request.getContextPath()+"/ErroreGenerico");
				}
			}else {
				String message = "I due campi devono corrispondere";
				Messaggio m= new Messaggio(0,"resetPassword",message);
				session.setAttribute("messaggio", m);
				response.sendRedirect(request.getContextPath()+"/ResetPassword");			
				}
			
		}catch(Exception e){
			response.sendRedirect(request.getContextPath()+"/ErroreGenerico");
		}
	}

}
