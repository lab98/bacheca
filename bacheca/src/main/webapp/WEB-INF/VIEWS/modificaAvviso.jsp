<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Avviso" %>
<%@ page import="models.Messaggio" %>
<%@ page import="java.util.LinkedList" %>
<% Messaggio m = (Messaggio)session.getAttribute("messaggio"); %>
<% Avviso avviso = (Avviso)session.getAttribute("avvisomod"); %>
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
	  var nome = document.getElementById("titolo").textContent;
	  var cognome = document.getElementById("testo").textContent;
	  var email = document.getElementById("datascad").textContent;
	  var ruolo = document.getElementById("livello").textContent;
	  
	  $.ajax({
          method: "POST",
          url: "ModificaAvviso",
          data:{ idAvviso: id, titolo: titolo, testo: testo, datascad: datascad, livello: livello },
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
    <h2 class="card-title">User Recap</h2>
  </div>
  <div class="card-body">
    <ul class="list-group list-group-flush">
      <li class="list-group-item">
        <span>Titolo:</span>
        <span id="titolo"><% out.print(avviso.getTitolo()); %></span>
        <button class="btn btn-link" onclick="editValue('titolo')">Edit</button>
      </li>
      <li class="list-group-item">
        <span>Testo:</span>
        <span id="testo"><% out.print(avviso.getTesto()); %></span>
        <button class="btn btn-link" onclick="editValue('testo')">Edit</button>
      </li>
      <li class="list-group-item">
        <span>Data Scadenza:</span>
        <span id="datascad"><% out.print(avviso.getDataScad());%></span>
        <button class="btn btn-link" onclick="editValue('datascad')">Edit</button>
      </li>
      <li class="list-group-item">
        <span>Livello Importanza:</span>
        <span id="livello"><% out.print(avviso.getLivello());%></span>
        <button class="btn btn-link" onclick="editValue('livello')">Edit</button>
      </li>
    </ul>
  </div>
  <div class="card-footer text-right">
    <button class="btn btn-primary" onclick="saveChanges(<% out.print(avviso.getIdAvviso()); %>)">Salva Modifiche</button>
  </div>
</div>

</section>
