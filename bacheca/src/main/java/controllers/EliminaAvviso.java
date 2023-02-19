package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.Query;

/**
 * Servlet implementation class EliminaAvviso
 */
@WebServlet("/EliminaAvviso")
public class EliminaAvviso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaAvviso() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			int id = Integer.parseInt(request.getParameter("idAvviso"));
			System.out.println(id);
			boolean deleted = Query.eliminaAvviso(id);
			if(deleted) {
				response.sendRedirect(request.getContextPath()+"GestioneAvvisi");
			}else {
				response.sendRedirect(request.getContextPath()+"ErroreGenerico");
			}
		}catch(Exception e) {
			response.sendRedirect(request.getContextPath()+"/ErroreGenerico");
		}
	}

}
