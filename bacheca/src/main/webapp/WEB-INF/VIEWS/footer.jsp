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

</head>


<body>
<style>
    html, body {
        height: 100%;
    }
  
    #footer {
        position: relative;
        bottom: 0;
        top: 20px;
        width: 100%;
        height: 100%
    }
</style>


    <!-- Your page content here -->
    <div id="footer" class="bg-danger text-light py-3">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <p class="mb-0">COMANDO PROVINCIALE VIGILI DEL FUOCO PALERMO</p>
                </div>
                <div class="col-md-6 text-md-end">
                    <p class="mb-0">Designed by :</p>
                    <p class="mb-0">>                    I.I. Luca La Barbera</p>
                    <p class="mb-0">>                    I.I. Ilenia Mannino</p>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-md-6 col-lg-4">
                    <h4>Contatti</h4>
                    <p><i class="bi bi-geo-alt-fill me-2"></i>Via Alessandro Scarlatti, 16, Palermo</p>
                    <p><i class="bi bi-phone-fill me-2"></i>(123) 456-7890</p>
                    <p><i class="bi bi-envelope-fill me-2"></i>comando.palermo@vigilfuoco.it</p>
                </div>
            </div>
        </div>
    </div>
</body>

</html>