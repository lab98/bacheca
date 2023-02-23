<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Avviso" %>
<%@ page import="models.Messaggio" %>
<%@ page import="java.util.LinkedList" %>
<% LinkedList<Avviso> avvisi = (LinkedList<Avviso>)session.getAttribute("avvisiValidi");%>

<section>
<div class="card-container">
<%if (avvisi.size()>0){ for(int i = 0; i<avvisi.size(); i++){%>
		<div class="card">
			<div class="card-title text-secondary">
				<h1><%out.print(avvisi.get(i).getTitolo()); %></h1>
			</div>
			<div class="card-content">
				<h3><%out.print(avvisi.get(i).getTesto()); %></h3>
				<small>Data Scadenza: <%out.print(avvisi.get(i).getDataScad()); %></small>
				<small>Livello Importanza: <%out.print(avvisi.get(i).getLivello()); %></small>
			</div>
		</div>
 <%}}%>
		
	</div>
	
<script>
const cardContainer = document.querySelector('.card-container');
const cards = document.querySelectorAll('.card');
let currentIndex = 0;
let intervalId;

function scrollToNextCard() {
  // Get the next card index
  currentIndex = (currentIndex + 1) % cards.length;
  const nextCard = cards[currentIndex];
  
  // Check if the next card is out of view
  const containerRect = cardContainer.getBoundingClientRect();
  const nextCardRect = nextCard.getBoundingClientRect();
  if (nextCardRect.bottom > containerRect.bottom) {
    // If the next card is out of view, scroll back to the first card
    cardContainer.scrollTo({
      top: 0,
      behavior: 'smooth'
    });
    currentIndex = 0;
  } else {
    // Otherwise, scroll to the next card
    nextCard.scrollIntoView({ behavior: 'smooth' });
  }
}

function startAutoScroll(intervalTime) {
  intervalId = setInterval(scrollToNextCard, intervalTime);
}

function stopAutoScroll() {
  clearInterval(intervalId);
}

cardContainer.addEventListener('mouseover', stopAutoScroll);
cardContainer.addEventListener('mouseout', () => startAutoScroll(5000));

startAutoScroll(5000);

setInterval(() => {
    window.location.reload();
}, 180000); // Reload the page every 3 minutes (180000 milliseconds)

</script>
</section>