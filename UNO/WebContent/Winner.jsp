<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Winner</title>
		<link rel="shortcut icon" href="Resources/favicon.png"/>
		<link rel='stylesheet' type='text/css' href='CSS/Winner.css'>
	</head>
	<body>
		<div id="container">
			<form class= "formulario" onsubmit="return add();">
				<h1>¡Ganaste!</h1>
				<input id = "gamerTag" placeholder="Ingresa tu Nombre"><br>
				<h4 style="">Score = </h4>
				<h4 id = "score"></h4><br><br>
				<button class="boton" type="submit">Continuar</button>
			</form>
		</div>
		<script src="Javascript/jquery.js"></script>
		<script src="Javascript/victory.js"></script>
		
	</body>
</html>