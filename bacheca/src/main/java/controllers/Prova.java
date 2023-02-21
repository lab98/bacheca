package controllers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.LinkedList;

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
import utils.Incremental;
import utils.Query;

/**
 * Servlet implementation class UserPage
 */
@WebServlet("/Prova")
@MultipartConfig

public class Prova extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String basePath = "WEB-INF/VIEWS/";         
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prova() {
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
			//Utente utente = (Utente) session.getAttribute("utente");
			System.out.println(1+livello+datascad+titolo+testo);
			System.out.println(datascad);
			System.out.println("ciao0");
			
			
			
			//Collection<Part> fileParts = (Collection<Part>) request.getPart("file"); 
			Part filePart = request.getPart("file");
			System.out.println("ciao1 "+filePart.toString());
			String contextPath = getServletContext().getRealPath("/");
			System.out.println("ciao2");
			File uploadsDir = new File(contextPath, "uploads");
			System.out.println("ciao3");
			if (!uploadsDir.exists()) {
			    uploadsDir.mkdir();
			    System.out.println("ciao4" + contextPath);
			}
			
			/**LinkedList<String> percorsi = new LinkedList<String>();
			for (Part filePart : fileParts) {
			    String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			    String fileName = originalFileName+Query.hashPassword(originalFileName+java.time.LocalDateTime.now().getNano());
			    String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			    InputStream fileContent = filePart.getInputStream();
			    Files.copy(fileContent, new File(uploadsDir, fileName + fileExtension).toPath());
			    percorsi.add(contextPath+"uploads/"+fileName);
			    System.out.println("ciao5");
			}**/
			 String originalFileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			    String fileName = originalFileName+Query.hashPassword(originalFileName+java.time.LocalDateTime.now().getNano());
			    String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			    InputStream fileContent = filePart.getInputStream();
			    Files.copy(fileContent, new File(uploadsDir, fileName + fileExtension).toPath());
			 String percorso = uploadsDir+fileName;
			
			/*** Query al db per il post * **/
			 System.out.println("ciao6");
			//Incremental i = new Incremental();
			//int idavviso=Incremental.getInstanceCount();
			 Utente utente = (Utente) session.getAttribute("utente");
			 System.out.println(utente);

			boolean published = Query.aggiungiAvviso(utente.getIdUtente(), livello, datascad, testo, titolo);
			 System.out.println("ciao7");
			boolean isAllegato=false;
			/**for(String percorso : percorsi) {
				isAllegato = Query.aggiungiAllegato(idavviso, percorso);
				 System.out.println("ciao8");
			}**/
			int idavviso = Query.getLastAvvisoIndex(utente.getIdUtente());
			isAllegato=Query.aggiungiAllegato(idavviso, percorso);
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
