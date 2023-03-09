<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="models.Messaggio" %>
<% Messaggio m= (Messaggio) session.getAttribute("messaggio");%>

<!DOCTYPE html>
<html>
<head>
<!-- <meta charset="UTF-8"> -->

<%@ include file="header.jsp" %>  
<%@ include file="navbarUser.jsp" %>  

</head>
<body>

<div class= "page-container">

   <div class="container">
    <h1 class="my-4">Pubblica Avviso</h1>
    <form action="UserPage" method="post" enctype="multipart/form-data">
      <div class="mb-3">
        <label for="postTitle" class="form-label">Titolo (massimo 45 caratteri)</label>
        <input type="text" class="form-control" id="titolo" name="titolo" placeholder="Inserisci titolo" maxlength="45" required>
      </div>
      <div class="mb-3">
        <label for="postContent" class="form-label">Testo (massimo 500 caratteri)</label>
        <textarea class="form-control" id="testo" name="testo" rows="8" placeholder="Inserisci testo dell'avviso" maxlength="500" required></textarea>
      </div>
      <div class="mb-3">
        <label for="postCategory" class="form-label">Livello Importanza</label>
        <select class="form-select" id="livello" name="livello">
<!--           <option selected disabled>Scegliere livello</option> -->
          <option selected value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
        </select>
      </div>
      <div class="mb-3">
        <label for="postDate" class="form-label">Data Scadenza</label>
        <input type="date" class="form-control" id="datascad" name="datascad" required>
      </div>
		<div class="mb-3">
		  <label for="formFileMultiple" class="form-label">Scegli file da inserire</label>
		  <input class="form-control" 
		  type="file" 
		  id="file"
		  name="file"
		  multiple 
		  accept="video/*, image/*">
		</div>
      <button type="submit"  class="btn btn-primary">Pubblica</button>
    </form>
    
   <div class="messaggio_avviso">
    <% if(m != null) { 
    	if(m.getJsp()=="aggiungiAvviso"&& m.getCodice()==1){%>
    	
 		    <div id="successo" class="alert alert-success">
    			<strong>Successo!</strong> ${messaggio.testo}
    		</div> 
    	
		<%session.removeAttribute("messaggio");
		
    	}else{%>
		
			<div id="errore" class="alert alert-success">
    			<strong>Errore!</strong> ${messaggio.testo}
    		</div>
    		
        
	<%	session.removeAttribute("messaggio");
		}
	} %>
		
    </div>
    
  </div>
  

<%-- <%@ include file="footer.jsp" %>   --%>
      </div>

</body>
</html>




