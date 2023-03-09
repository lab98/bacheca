<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="models.Utente" %>
<%@ page import="models.Avviso" %>
<%@ page import="models.Messaggio" %>
<%@ page import="java.util.LinkedList" %>
<% Messaggio m = (Messaggio)session.getAttribute("messaggio"); %>
<% LinkedList<Avviso> avvisi = (LinkedList<Avviso>)session.getAttribute("listaAvvisi"); %>


<!DOCTYPE html>
<html>
<head>

<%@ include file="meta.jsp" %>

<%@ include file="header.jsp" %>  
<%@ include file="navbarUser.jsp" %>  

</head>
<body>

<script type="text/javascript">
        $(document).ready(function() {
        	
        });
        function elimina(id){
    		console.log("provo ad eliminare");
    		$.ajax({
                method: "POST",
                url: "EliminaAvviso",
                data:{ idAvviso: id},
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


<div class= "page-container">

	<div class="container">
		<h1>Gestione Avvisi</h1>
		  <div class="row">
	
		 <div class="col-md-8">
		  <form id="search-form">
		    <div class="form-group">
		      <label for="search-input">Inserisci parola chiave per cercare gli avvisi:</label>
		      <input type="text" class="form-control" id="search-input">
		    </div>
	 			<div class='btn btn-primary' id="search-button" onclick="search()">Cerca</div>	  
		</form>
		</div>
	

	      
	<div class="col-md-20" id="card_section">
	
	<h3>Avvisi trovati:</h3>
	<%if (avvisi.size()>0){ 
		for(int i = 0; i<avvisi.size(); i++)
		{%>
		  <div class="card">
		    <div class="card-body">
		      <h4 class="card-title" ><% out.print(avvisi.get(i).getTitolo());%></h4>
		      <p class="card-text"><% out.print(avvisi.get(i).getTesto()); %></p>
		      <a href="ModificaAvviso?idAvviso=<% out.print(avvisi.get(i).getIdAvviso());%>" id="ModificaAvviso" class="btn btn-secondary mr-2">Modifica</a>
		      <button type="submit"  class="btn btn-danger" onclick="elimina(<% out.print(avvisi.get(i).getIdAvviso()); %>)">Elimina</button>
		    </div>
		     <p class="data-scadenza">Data di scadenza : <% out.print(avvisi.get(i).getDataScad()); %></p>
		  </div>
	 	<%}
		} %>
	</div>
	</div>

</div>

<%-- 			<%@ include file="footer.jsp" %>  --%>

</div>

 	
</body>
<script src="javascript/GestioneAvvisi.js"></script>
</html>


