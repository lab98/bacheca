<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Messaggio" %>
<% Messaggio m= (Messaggio) session.getAttribute("messaggio");%>
 <script type="text/javascript">
        $(document).ready(function() {
        	$("#nome, #cognome, #email, #password, #ruolo").keyup(function(){
            	$("#errore").hide();
        	});
        });
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
  <div class="row justify-content-center">
    <div class="col-md-6">
      <div class="card shadow-lg p-3 mb-5 rounded bg-primary text-white">
        <div class="card-header bg-danger">
          <h3 class="card-title mb-0" >Aggiungi Nuovo Utente</h3>
        </div>
        <div class="card-body">
          <form method="post" action="AdminPage">
            <div class="mb-3">
              <label for="nome" class="form-label">Nome:</label>
              <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            </div>
              <div class="mb-3">
              <label for="cognome" class="form-label">Cognome:</label>
              <input type="text" class="form-control" id="cognome" name="cognome" required>
            </div>
            <div class="mb-3">
              <label for="email" class="form-label">Email:</label>
              <input type="email" class="form-control" id="email" name="email" pattern="[^@]+@vigilfuoco.it" required>
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Password:</label>
              <input type="password" class="form-control" id="password" name="password" required>
            </div>
              <div class="mb-3">
              <label for="ruolo" class="form-label">Ruolo:</label>
              <input type="text" class="form-control" id="ruolo" name="ruolo" required>
            </div>
            <div class="form-group mb-3">
              <label for="tipo">Tipo:</label>
              <select class="form-select" id="tipo" name="tipo" required>
                <option value="" selected>--- Scegli ---</option>
                <option value="utente">Utente</option>
                <option value="admin">Admin</option>
              </select>
            </div>
            <button type="submit" class="btn-danger">Aggiungi</button>
          </form>
        </div>
      </div>
    </div>
  </div>
<div class="row">
		<div class="col-2">
		</div>
		<div class="col-8">
		<% if(m != null) { if(m.getJsp()=="aggiungiUtente"&& m.getCodice()==0){%>
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
		<% if(m != null) { if(m.getJsp()=="aggiungiUtente"&& m.getCodice()==1){%>
		    <div id="errore" class="alert alert-success">
    			<strong>Successo!</strong> ${messaggio.testo}
    		</div>
    	
		<%	session.removeAttribute("messaggio");
		}} %>
			
  			
		</div>
		<div class="col-2">
		</div>
</div>
</body>
</html>