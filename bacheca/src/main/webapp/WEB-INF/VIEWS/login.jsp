<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Messaggio" %>
<% Messaggio m= (Messaggio) session.getAttribute("messaggio");%>
<section>
<script type="text/javascript">
        $(document).ready(function() {
        	$("#email, #password").keyup(function(){
            	$("#errore").hide();
        	});
        });
</script>
    <div class="container mt-5">
      <div class="row justify-content-center">
        <div class="col-md-6 col-lg-4">
          <div class="card">
            <div class="card-header bg-primary text-white text-center">
              <h4>Login</h4>
            </div>
            <div class="card-body">
              <form action="Login" class="was-validated" method="post">
                <div class="form-group">
                  <label for="username">Username</label>
                  <input type="text" class="form-control" id="email" name="email" placeholder="nome.cognome@vigilfuoco.it" pattern="[^@]+@vigilfuoco.it" required>
                </div>
                <div class="form-group">
                  <label for="password">Password</label>
                  <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Login</button>
              </form>
            </div>
            <div class="card-footer">
              <p class="text-muted text-center mb-0">Password Dimenticata?</p>
              <form class="mt-3">
                <div class="form-group">
                  <input type="email" class="form-control" id="email" placeholder="Enter your email">
                </div>
                <button type="submit" class="btn btn-primary btn-block">Reset Password</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

<div class="row">
		<div class="col-2">
		</div>
		<div class="col-8">
		<% if (m != null) { if(m.getJsp()=="login") { %>
		    <div id="errore" class="alert alert-danger">
    			<strong>Errore!</strong> ${messaggio.testo}
    		</div>
		<% 	session.removeAttribute("messaggio");
		}} %>
			
  			
		</div>
				<div class="col-2">
		</div>
	</div>
	</section>