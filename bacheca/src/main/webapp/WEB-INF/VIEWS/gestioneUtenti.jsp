<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Utente" %>
<%@ page import="models.Messaggio" %>
<%@ page import="java.util.LinkedList" %>
<% Messaggio m = (Messaggio)session.getAttribute("messaggio"); %>
<% LinkedList<Utente> utenti = (LinkedList<Utente>)session.getAttribute("listaUtenti"); %>


<!DOCTYPE html>
<html>
<head>

<%@ include file="meta.jsp" %>

<%@ include file="header.jsp" %>  
<%@ include file="navbarAdmin.jsp" %>  

</head>
<body>


<script type="text/javascript">
        $(document).ready(function() {
        	
        });
        function elimina(id){
    		console.log("provo ad eliminare");
    		$.ajax({
                method: "POST",
                url: "EliminaUser",
                data:{ idUtente: id},
                async: false,
                success : function (data,stato) {
                	location.reload();
                },
                error : function (richiesta,stato,errori) {
                	location.reload();
                }
            });
    	};
    	
</script>
<div class="container">

	<h1>Gestione Utenti</h1>
  <div class="row">

 <div class="col-md-8">
  <form>
    <div class="form-group">
      <label for="search-input">Cerca Utente:</label>
      <input type="text" class="form-control" id="search-input">
    </div>
    
    <div class='btn btn-primary' id="search-button" onclick="search()">Cerca</div>	 
    
  </form>
</div>



<div class="col-md-10" id="card_section">


<h3>Utenti trovati:</h3>
<%if (utenti.size()>0){ for(int i = 0; i<utenti.size(); i++){%>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title"><% out.print(utenti.get(i).getCognome()+ " "+utenti.get(i).getNome()); %></h5>
      <p class="card-text"><% out.print(utenti.get(i).getEmail()); %></p>
      <a href="ModificaUser?idUtente=<% out.print(utenti.get(i).getIdUtente());%>" id="ModificaUser" class="btn btn-secondary mr-2">Modifica</a>
      <a href="ReimpostaPasswordUser?idUtente=<% out.print(utenti.get(i).getIdUtente());%>" id="ReimpostaPasswordUser" class="btn btn-warning mr-2">Password</a>
      <button type="submit"  class="btn btn-danger" onclick="elimina(<% out.print(utenti.get(i).getIdUtente()); %>)">Elimina</button>
    </div>
  </div>
 <%}} %>
</div>

  </div>
</div>

<div class="row">
		<div class="col-2">
		</div>
		<div class="col-8">
  			<% if(m != null) { if(m.getJsp()=="gestioneUtenti"&& m.getCodice()==0){ %>
		    <div id="avviso" class="alert alert-warning">
    			<strong>Avviso!</strong> ${messaggio.testo}
    		</div>
    		<%	session.removeAttribute("messaggio");
				}} %> 
    	</div>
		<div class="col-2">
		</div>
	</div>

<%--  	<%@ include file="footer.jsp" %>  --%>
 	
</body>
<script src="javascript/GestioneAvvisi.js"></script>
</html>