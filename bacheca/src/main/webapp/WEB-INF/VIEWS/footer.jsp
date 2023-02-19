<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<section>
<footer class="footer fixed-bottom bg-danger">
  <div class="container-fluid">
    <div class="row">
      <div class="col-12 col-md-6 text-start">
        <p class="text-white">&copy; 2023 My Website</p>
      </div>
      <div class="col-12 col-md-6 text-end">
        <p class="text-white">Designed by Me</p>
      </div>
    </div>
  </div>
</footer>
</section>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>


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
	  
	  alert("Changes saved successfully!");
	}
</script>
</body>
</html>