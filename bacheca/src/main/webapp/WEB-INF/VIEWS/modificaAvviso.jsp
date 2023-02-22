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

</script>
<section>
  <div class="container">
    <h1 class="my-4">Modifica Avviso</h1>
    <form action="ModificaAvviso" method="post">
      <div class="mb-3">
        <label for="postTitle" class="form-label">Titolo (massimo 45 caratteri)</label>
        <input type="text" class="form-control" id="titolo" name="titolo" value="<% out.print(avviso.getTitolo());%>" maxlength="80" required>
      </div>
      <div class="mb-3">
        <label for="postContent" class="form-label">Testo (massimo 500 caratteri)</label>
        <textarea class="form-control"  id="testo" name="testo" rows="8" placeholder="<% out.print(avviso.getTesto());%>" maxlength="500" required></textarea>
      </div>
      <div class="mb-3">
        <label for="postCategory" class="form-label">Livello Importanza</label>
        <select class="form-select" id="livello" name="livello" required>
          <option value="1">1 (basso)</option>
          <option value="2">2 (medio basso)</option>
          <option value="3">3 (medio)</option>
          <option value="4">4 (medio alto)</option>
          <option value="5">5 (alto)</option>
        </select>
      </div>
      <div class="mb-3">
        <label for="postDate" class="form-label">Data Scadenza</label>
        <input type="date" class="form-control" id="datascad" name="datascad" required>
      </div>
      <button type="submit" onclick="saveChanges(<% out.print(avviso.getIdAvviso());%>)" class="btn btn-primary">Salva Modifiche</button>
      
      <div class="messaggio_avviso">
<%-- 		    <% if(m != null) { 
		    	if(m.getJsp()=="aggiungiAvviso"&& m.getCodice()==1){%>
		    	
		 		    <div id="successo" class="alert alert-success">
		    			<strong>Successo!</strong> ${messaggio.testo}
		    		</div> 
		    	
				<%}else{%>
				
					<div id="errore" class="alert alert-success">
		    			<strong>Errore!</strong> ${messaggio.testo}
		    		</div>
			<%	}
		    	session.removeAttribute("messaggio");
				} %> --%>
				
    </div>
    </form>
  </div>
</section>
