<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="models.Utente" %>
    <%@ page import="models.Messaggio" %>
    <% Utente utente = (Utente)session.getAttribute("modificato"); %>
    <% Messaggio m= (Messaggio) session.getAttribute("messaggio");%>
    
 <!DOCTYPE html>
<html>
<head>

<%@ include file="meta.jsp" %>

<title>Insert title here</title>

<%@ include file="header.jsp" %>  
<%@ include file="navbarUser.jsp" %>  

</head>
<body>

    <div class="container"> 
      <h1>Modifica Password</h1>
      <form action="ReimpostaPasswordUser" method="post">
        <div class="form-group">
          <label for="password">Nuova Password</label>
          <input type="password" class="form-control" id="password" name="password" placeholder="Enter new password" required>
        </div>
        <div class="form-group">
          <label for="confirm-password">Conferma Password hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh</label>
          <input type="password" class="form-control" id="confirm-password" name="confirm-password" placeholder="Confirm new password" required>
        </div>
        <button type="submit" class="btn btn-primary" onclick="confirm()">Reimposta Password</button>
      </form>
    </div>
    
    <div class="row">
		<div class="col-2">
		</div>
		<div class="col-8">
		<% if(m != null) { if(m.getJsp()=="resetPassword"&& m.getCodice()==0){%>
		    <div id="errore" class="alert alert-danger">
    			<strong>Errore!</strong> ${messaggio.testo}
    		</div>
    	
		<%	session.removeAttribute("messaggio");
		}} %>
			
  			
		</div>
		<div class="col-2">
		</div>
</div>
<div class="row">
		<div class="col-2">
		</div>
		<div class="col-8">
		<% if(m != null) { if(m.getJsp()=="resetPassword"&& m.getCodice()==1){%>
		    <div id="successo" class="alert alert-success">
    			<strong>Successo!</strong> ${messaggio.testo}
    		</div>
    	
		<%	session.removeAttribute("messaggio");
		}} %>
			
  			
		</div>
		<div class="col-2">
		</div>
</div>

<%@ include file="footer.jsp" %>  

</body>
</html>