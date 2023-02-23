 
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

<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="css/SchermataAvvisi.css"> 

<%@ include file="header.jsp" %>  
<%@ include file="navbar.jsp" %>  

</head>
<body>

<div id="carosello_avvisi" class="carousel slide" data-ride="carousel" data-interval="3000">
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

<!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script> -->
  

</body>
</html>


