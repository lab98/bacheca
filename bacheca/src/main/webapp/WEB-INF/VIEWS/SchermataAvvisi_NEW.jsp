 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Avviso" %>
<%@ page import="models.Messaggio" %>
<%@ page import="java.util.LinkedList" %>
 <% LinkedList<Avviso> avvisi = (LinkedList<Avviso>)session.getAttribute("avvisiValidi");%>


 <!DOCTYPE html>
<html>
<head>

<%@ include file="meta.jsp" %>

<link rel="stylesheet" type="text/css" href="css/SchermataAvvisi.css"> 

<%@ include file="header.jsp" %>  
<%@ include file="navbar.jsp" %>  

</head>
<body>

<div id="carosello_avvisi" class="carousel slide" data-ride="carousel" data-interval="5000">
  <div class="carousel-inner">
  <%if (avvisi.size()>0){
	  %>
	  <div class="carousel-item active">
      	<div class="card-title_text-secondary">
				<h1 ><%out.print(avvisi.get(0).getTitolo()); %></h1>
	  	</div>
	  	<div class="card-content">
				<h3><%out.print(avvisi.get(0).getTesto()); %></h3>

	  	</div>
      </div>
	  <% 
	  for(int i = 1; i<avvisi.size(); i++)
	  {%>
		<div class="carousel-item">
			<div class="card-title_text-secondary">
				<h1><%out.print(avvisi.get(i).getTitolo()); %></h1>
			</div>
			<div class="card-content">
				<h3><%out.print(avvisi.get(i).getTesto()); %></h3>

			</div>

		</div>
 		<%}
	  }%>
  </div>
</div> 



<div class="tickerwrapper">
   <ul class='list'>
           <%if (avvisi.size()>0){
			  for(int i = 0; i<avvisi.size(); i++)
			  {%>
      			<li class='listitem'>
			  		<p class='barra'> <%out.print(avvisi.get(i).getTesto()); %> --- </p>
			  </li>
		   		<%}
	  }%>

  </ul>
</div> 



<script>
setInterval(() => {
    window.location.reload();
}, 180000); // Reload the page every 3 minutes (180000 milliseconds)
</script>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/gsap/3.11.4/gsap.min.js" ></script>	

<script type="text/javascript" src="javascript/SchermataAvvisi.js" ></script>	


</body>
</html>


