package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import models.Messaggio;
import models.Utente;
import utils.Query;

/**
 * Servlet implementation class UserPage
 */
@WebServlet("/UserPage")
@MultipartConfig

public class UserPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String basePath = "WEB-INF/VIEWS/";         
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserPage() {
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
		dispatcher = request.getRequestDispatcher(basePath+"navbarUser.jsp");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher(basePath+"aggiungiAvviso.jsp");
		dispatcher.include(request, response);
		dispatcher = request.getRequestDispatcher(basePath+"footer.jsp");
		dispatcher.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String titolo = request.getParameter("titolo");
			String testo = request.getParameter("testo");	
			String livello = request.getParameter("livello"); 
			String datascad = request.getParameter("datascad");
			
			
			Part filePart = request.getPart("file");
			 String originalFileName=null; // MSIE fix.
			 String fileName=null;
			 String fileExtension=null;
			 InputStream fileContent=null;
			 String percorso=null;
			 String contextPath = getServletContext().getRealPath("/");
			 File uploadsDir = new File(contextPath, "uploads");
			 System.out.println("ciao3");
			 if (!uploadsDir.exists()) {
				 uploadsDir.mkdir();
				 System.out.println("ciao4" + contextPath);
				}
				
			if(filePart!=null) {
				 originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
				 fileName = originalFileName+Query.hashPassword(originalFileName+java.time.LocalDateTime.now().getNano());
				 fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
				 fileContent = filePart.getInputStream();
				 Files.copy(fileContent, new File(uploadsDir, fileName + fileExtension).toPath());
				 percorso = uploadsDir+fileName;
			}



			 System.out.println("ciao6");
			 Utente utente = (Utente) session.getAttribute("utente");
			 System.out.println(utente);

			boolean published = Query.aggiungiAvviso(utente.getIdUtente(), livello, datascad, testo, titolo);
			 System.out.println("ciao7");
			boolean isAllegato=true;

			int idavviso = Query.getLastAvvisoIndex(utente.getIdUtente());
			if(percorso!=null) {
				isAllegato=Query.aggiungiAllegato(idavviso, percorso);
			}
			if(published&&isAllegato) {
				String message = "Avviso Pubblicato correttamente ";
				Messaggio m = new Messaggio(1,"aggiungiAvviso",message);
				session.setAttribute("messaggio", m);
				response.sendRedirect(request.getContextPath()+"/UserPage");
			}else {
				String message = "Avviso non Pubblicato correttamente ";
				Messaggio m = new Messaggio(0,"aggiungiAvviso",message);
				session.setAttribute("messaggio", m);
				response.sendRedirect(request.getContextPath()+"/ErroreGenerico");
			}
			
		}catch(Exception e) {
			response.sendRedirect(request.getContextPath()+"/ErroreGenerico");
		}
	}

}
