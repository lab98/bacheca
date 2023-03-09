<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="models.Utente" %>
     	  
      <%
      response.setHeader("Cache-Control","no-cache");
      response.setHeader("Cache-Control","no-store");
      response.setHeader("Pragma","no-cache");
      response.setDateHeader ("Expires", 0);
      Utente utente_loggato = (Utente)session.getAttribute("utente");
      
      if(utente_loggato!=null){
    	  out.print("navbar admin " + utente_loggato.getNome());
    	  %>

    	  <nav class="navbar navbar-expand-lg navbar-light bg-danger">
    	    <div class="container-fluid">
    	      <a class="navbar-brand text-white" href="UserPage">Bacheca COM-PA</a>
    	      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    	        <span class="navbar-toggler-icon"></span>
    	      </button>
    	      <div class="collapse navbar-collapse" id="navbarNav">
    	        <ul class="navbar-nav w-100">
    	          <li class="nav-item">
    	            <a class="nav-link text-white" href="UserPage">Pubblica Avviso</a>
    	          </li>
    	          <li class="nav-item">
    	            <a class="nav-link text-white" href="GestioneAvvisi">Gestione Avvisi</a>
    	          </li>
    	          <li class="nav-item">
    	            <a class="nav-link text-white" href="ResetPassword">Cambia Password</a>
    	          </li>
    	          <li class="nav-item">
    	            <a class="nav-link text-white" href="Logout">Logout</a>
    	          </li>
    	          <li class="nav-item ml-auto"  >
    	          	<a class="nav-link text-white" >Benvenuto <% out.print(utente_loggato.getNome());%> </a>
    	          </li>
    	        </ul>
    	      </div>
    	    </div>
    	  </nav>

	<% 
      }else{
    	  RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
    	   rd.forward(request, response);
      }
      %>
    
    