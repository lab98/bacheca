<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="models.Utente" %>
<%@ page import="models.Avviso" %>
<%@ page import="models.Messaggio" %>
<%@ page import="java.util.LinkedList" %>
<% Messaggio m = (Messaggio)session.getAttribute("messaggio"); %>
<% LinkedList<Avviso> avvisi = (LinkedList<Avviso>)session.getAttribute("listaAvvisi"); %>
<section>
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
<div class="container">
  <div class="row">
    <div class="col-md-4">
      <!-- Search options -->
 <div class="col-md-8">
  <form>
    <div class="form-group">
      <label for="search-input">Search:</label>
      <input type="text" class="form-control" id="search-input">
    </div>
    <button type="submit" class="btn btn-primary" id="search-button">Search</button>
  </form>
</div>
</div>
<div class="col-md-8">
      <!-- User card section -->
<div class="col-md-10" id="card-section">
<%if (avvisi.size()>0){ for(int i = 0; i<avvisi.size(); i++){%>
  <div class="card">
    <div class="card-body">
      <h5 class="card-title"><% out.print(avvisi.get(i).getTitolo());%></h5>
      <p class="card-text"><% out.print(avvisi.get(i).getTesto()); %></p>
      <a href="ModificaAvviso?idAvviso=<% out.print(avvisi.get(i).getIdAvviso());%>" id="ModificaAvviso" class="btn btn-secondary mr-2">Modifica</a>
      <button type="submit"  class="btn btn-danger" onclick="elimina(<% out.print(avvisi.get(i).getIdAvviso()); %>)">Elimina</button>
    </div>
  </div>
 <%}} %>
</div>
    </div>
  </div>
</div>

<div class="row">
		<div class="col-2">
		</div>
		<div class="col-8">
  			<% if(m != null) { if(m.getJsp()=="gestioneAvvisi"&& m.getCodice()==0){ %>
		    <div id="avviso" class="alert alert-warning">
    			<strong>Avviso!</strong> ${messaggio.testo}
    		</div>
    		<%	session.removeAttribute("messaggio");
				}} %> 
    	</div>
		<div class="col-2">
		</div>
	</div>
<script type="text/javascript">
function search() {
	  // Get the input value and convert it to lowercase
	  var input = document.getElementById("search-input").value.toLowerCase();
	  // Get the card section element
	  var cards = document.getElementById("card-section").getElementsByClassName("card");

	  // Loop through all the cards and hide those that don't match the search query
	  for (var i = 0; i < cards.length; i++) {
	    var name = cards[i].getElementsByClassName("card-title")[0];
	    var bio = cards[i].getElementsByClassName("card-text")[0];
	    if (name.innerHTML.toLowerCase().indexOf(input) > -1 || bio.innerHTML.toLowerCase().indexOf(input) > -1) {
	      cards[i].style.display = "";
	    } else {
	      cards[i].style.display = "none";
	    }
	  }
	}


// Get the search form and submit button
var form = document.getElementById("search-form");
var button = document.getElementById("search-button");
function search() {
	  // Get the input value and convert it to lowercase
	  var input = document.getElementById("search-input").value.toLowerCase();
	  // Get the card section element
	  var cards = document.getElementById("card-section").getElementsByClassName("card");

	  // Loop through all the cards and hide those that don't match the search query
	  for (var i = 0; i < cards.length; i++) {
	    var name = cards[i].getElementsByClassName("card-title")[0];
	    var bio = cards[i].getElementsByClassName("card-text")[0];
	    if (name.innerHTML.toLowerCase().indexOf(input) > -1 || bio.innerHTML.toLowerCase().indexOf(input) > -1) {
	      cards[i].style.display = "";
	    } else {
	      cards[i].style.display = "none";
	    }
	  }
	}


// Get the search form and submit button
var form = document.getElementById("search-form");
var button = document.getElementById("search-button");

// Add event listener to submit button
button.addEventListener("click", function(event) {
event.preventDefault();
search();
});
</script>
</section>
    