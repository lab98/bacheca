<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="models.Messaggio" %>
<% Messaggio m= (Messaggio) session.getAttribute("messaggio");%>

<!DOCTYPE html>
<html>
<head>

<%@ include file="meta.jsp" %>

<%@ include file="header.jsp" %>  
<%@ include file="navbar.jsp" %>  

</head>
<body>

<script type="text/javascript">
        $(document).ready(function() {
        	$("#email, #password").keyup(function(){
            	$("#errore").hide();
        	});
        });
</script>
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-md-6 col-lg-4">
          <div class="card">
            <div class="card-header bg-primary text-white text-center">
              <h4>Benvenuto!</h4>
            </div>
            <div class="card-body">
              <form action="Login" class="login" method="post">
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

	<%@ include file="footer.jsp" %>  

</body>
</html>
	