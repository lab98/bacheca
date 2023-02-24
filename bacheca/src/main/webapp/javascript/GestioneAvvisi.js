
function search() {
	  // Get the input value and convert it to lowercase
/*	  var input = document.getElementById("prova").value.toLowerCase();
*/	  
	var input = document.getElementById("search-input").value.toLowerCase();
	  // Get the card section element
	  var cards = document.getElementById("card_section").getElementsByClassName("card");

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
	

