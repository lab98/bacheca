<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="models.Utente" %>
    <%@ page import="models.Messaggio" %>
    <% Utente utente = (Utente)session.getAttribute("utente"); %>
    <% Messaggio m= (Messaggio) session.getAttribute("messaggio");%>
  
 <!DOCTYPE html>
<html>
<head>

<%@ include file="meta.jsp" %>

<%@ include file="header.jsp" %>  
<%@ include file="navbarUser.jsp" %>  

</head>
<body>   


    <div class="container">
      <h1>Modifica Password</h1>
      <form action="ResetPassword" method="post">
        <div class="form-group">
          <label for="password">Nuova Password</label>
          <input type="password" class="form-control" id="password" name="password" placeholder="Inserisci la nuova password" required>
        </div>
        <div class="form-group">
          <label for="confirm-password">Conferma Password</label>
          <input type="password" class="form-control" id="confirm-password" name="confirm-password" placeholder="Conferma la nuova password" required>
        </div>
        <button type="submit" class="btn btn-primary">Reimposta Password</button>
      </form>
      
      <div class="row">

		<div class="col-8">
		<% if(m != null) { 
			if(m.getJsp()=="resetPassword"&& m.getCodice()==1){
			%>
		    <div id="successo" class="alert alert-success">
    			<strong>Successo!</strong> ${messaggio.testo}
    		</div>
    	
		<%	session.removeAttribute("messaggio");
		
			}else{
			%>
			<div id="errore" class="alert alert-danger">
			<strong>Errore!</strong> ${messaggio.testo}
			</div>
			
			<% session.removeAttribute("messaggio");
		}} %>
			
  			
		</div>

		</div>
    </div>



<%@ include file="footer.jsp" %>  

</body>
</html>
