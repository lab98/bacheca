<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Bootstrap Modern Footer with Contact Information</title>
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<!-- Custom CSS -->
	<style>
		.footer {
			background-color: #dc3545;
			padding: 60px 0;
			margin-top: 50px;
		}
		.footer h3 {
			color: #ffff;
			margin-bottom: 30px;
			font-weight: bold;
		}
		.footer ul {
			list-style: none;
			padding-left: 0;
			color: #000f
		}
		.footer ul li {
			margin-bottom: 10px;
			color: #000f;
		}
		.footer ul li i {
			font-size: 24px;
			margin-right: 10px;
			color: #000f;
		}
		.footer p {
			margin-top: 30px;
			color: #000f
			
		}
	</style>
</head>
<body>
	<footer class="footer">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-sm-6">
					<h3>Contact Us</h3>
					<ul>
						<li><i class="fa fa-map-marker"></i>Comando Provinciale Vigili del Fuoco, Palermo</li>
						<li><i class="fa fa-phone"></i>Via Scarlatti, 16 - PA</li>
						<li><i class="fa fa-envelope"></i>comando.palermo@vigilfuico.it</li>
					</ul>
				</div>
				<div class="col-md-4 col-sm-12">
					<h3>About Us</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sed dapibus leo nec ornare diam.</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>