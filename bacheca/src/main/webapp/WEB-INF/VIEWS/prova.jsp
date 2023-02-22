<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="models.Avviso" %>
<%@ page import="models.Messaggio" %>
<%@ page import="java.util.LinkedList" %>
 <% LinkedList<Avviso> avvisi = (LinkedList<Avviso>)session.getAttribute("avvisiValidi");%>
    
<head>
<style type="text/css">
.news {
  width: 40%;
  margin: 2rem auto;
}

.news-items {
  position: relative;
  height: 200px;
  overflow: hidden;
}

.news-item {
  position: absolute;
  top: 0;
  left: 0;
  opacity: 0;
  transition: opacity 0.5s ease-in-out;
}

.news-item.active {
  opacity: 1;
}

.news-title {
  font-size: 4rem;
  margin-bottom: 1rem;
}

.news-content {
  font-size: 2rem;
  line-height: 1.6;
}


</style>
</head>
<section class="news">
  <div class="news-items">
  
    <%if (avvisi.size()>0){
	  %>
	<div class="news-item active">
      <h2 class="news-title"><%out.print(avvisi.get(0).getTitolo()); %></h2>
      <p class="news-content"><%out.print(avvisi.get(0).getTesto()); %></p>
       <%if (avvisi.get(0).getAllegati().size()>0){
	  %>
	  <img src="<%out.print(avvisi.get(0).getAllegati().getFirst().getPercorso());%>">
	  <%} %>
    </div>
	  <% 
	  for(int i = 1; i<avvisi.size(); i++)
	  {%>
		<div class="news-item">
      <h2 class="news-title"><%out.print(avvisi.get(i).getTitolo()); %></h2>
      <p class="news-content"><%out.print(avvisi.get(i).getTesto()); %></p>
       <%if (avvisi.get(i).getAllegati().size()>0){
	  %>
	  <img src="<%out.print(avvisi.get(i).getAllegati().getFirst().getPercorso());%>">
	  <%} %>
    </div>
	  <%} }%>
  </div>
</section>
</section>
  
  <script type="text/javascript">
  const newsItems = document.querySelectorAll('.news-item');
  let activeIndex = 0;

  setInterval(() => {
    newsItems[activeIndex].classList.remove('active');
    activeIndex = (activeIndex + 1) % newsItems.length;
    newsItems[activeIndex].classList.add('active');
  }, 5000);
  </script>
</section>
