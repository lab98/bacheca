<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Bacheca COM-PA</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- Custom CSS -->



</head>
<body>
	<style>
		.navbar {
			background-color: #dc3545;
			color: #fff;
		}
		.navbar-brand {
			color: #fff;
			font-weight: bold;
		}
		.nav-link {
			color: #fff;
		}
		.nav-link:hover {
			color: #fff;
		}
	</style>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="Login"><img id="logo_comando" alt="COM-PA"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
					<a class="nav-link" id="AdminPage" href="AdminPage">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="GestioneUtenti" href="GestioneUtenti">Utenti</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" id="Logout" href="Logout">Logout</a>
				</li>
				
			</ul>
		</div>
	</nav>


</html>