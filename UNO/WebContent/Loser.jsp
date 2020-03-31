<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Loser</title>
		<meta name="author" content="Alexis">
		<meta name="author" content="Andrés">
		<meta name="author" content="Alexandra">
		<meta name="author" content="Marco">
		<meta name="description" content="Pantalla del Perdedor">
		<link rel="shortcut icon" href="Resources/favicon.png"/>
		<link rel='stylesheet' type='text/css' href='CSS/Loser.css'>
	</head>
	<body>
		<div id="container">
			<form class= "formulario">
				<h1>¡Perdiste!</h1>
				<button class="boton" type="button" onclick="return next();">Continuar</button>
			</form>
		</div>
		<script src="Javascript/jquery.js"></script>
		<script>
			function next(){
				location = "index.jsp";
			}
		</script>
		
	</body>
</html>