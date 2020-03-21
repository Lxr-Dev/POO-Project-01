<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="description" content="Botón de Inicio de Partida"> 
		<title>Insert title here</title>
	</head>
	<body>
		<form onsubmit = "return start();">
			<input type="text" name="gamerTag" id="gamerTag" placeholder="Ingrese su nombre de Jugador">
			<button type="submit" >Enviar</button>
		</form>
		<script src="jquery.js"></script>
		<script src="script.js"></script>
	</body>
</html>