<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Utente" %>
<%@ page import="models.Messaggio" %>
<%@ page import="java.util.LinkedList" %>
<% Messaggio m = (Messaggio)session.getAttribute("messaggio"); %>
<% Utente utente = (Utente)session.getAttribute("modificato"); %>
<script>
$(document).ready(function() {
	
});
function editValue(id) {
	  var value = document.getElementById(id);
	  var newValue = prompt("Enter new value:");
	  if (newValue !== null) {
	    value.textContent = newValue;
	  }
	}
function saveChanges(id) {
	  var nome = document.getElementById("nome").textContent;
	  var cognome = document.getElementById("cognome").textContent;
	  var email = document.getElementById("email").textContent;
	  var ruolo = document.getElementById("ruolo").textContent;
	  console.log(nome);
	  
	  $.ajax({
          method: "POST",
          url: "ModificaUser",
          data:{ idUtente: id, nome: nome, cognome: cognome, email: email, ruolo: ruolo },
          async: false,
          success : function (data,stato) {
          	location.reload();
          },
          error : function (richiesta,stato,errori) {
          	location.reload();
          }
      });
	  
	  alert("Modifiche Salvate con Successo !");
	}
</script>
<section>
<div class="card">
  <div class="card-header">
    <h2 class="card-title">Modifica utente</h2>
  </div>
  <div class="card-body">
    <ul class="list-group list-group-flush">
      <li class="list-group-item">
        <span>Nome:</span>
        <span id="nome"><% out.print(utente.getNome()); %></span>
        <button class="btn btn-link" onclick="editValue('nome')">Modifica</button>
      </li>
      <li class="list-group-item">
        <span>Cognome:</span>
        <span id="cognome"><% out.print(utente.getCognome()); %></span>
        <button class="btn btn-link" onclick="editValue('cognome')">Modifica</button>
      </li>
      <li class="list-group-item">
        <span>Email:</span>
        <span id="email"><% out.print(utente.getEmail());%></span>
        <button class="btn btn-link" onclick="editValue('email')">Modifica</button>
      </li>
      <li class="list-group-item">
        <span>Ruolo:</span>
        <span id="ruolo"><% out.print(utente.getRuolo());%></span>
        <button class="btn btn-link" onclick="editValue('ruolo')">Modifica</button>
      </li>
    </ul>
  </div>
  <div class="card-footer text-right">
    <button class="btn btn-primary" onclick="saveChanges(<% out.print(utente.getIdUtente()); %>)">Salva Modifiche</button>
  </div>
</div>

</section>
