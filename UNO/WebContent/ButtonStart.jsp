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
		<form id = "nuevaPartida" onsubmit = "return generateCode();">
			<input type="text" name="codeS" id="codeS">
			<button type="submit" >Generar Código</button>
			<button type="button" onclick="Start();" >Iniciar</button>
		</form><br><br>
		
		<form id = "unirse" onsubmit = "return join();">
			<input type="text" name="code" id="code" placeholder="Ingresa el código de tu amigo">
			<button type="submit">Unirse</button>
		</form>
		<script>
			window.onload = function(){document.querySelector("input#codeS").disabled = true}
		</script>
		<script src="jquery.js"></script>
		<script src="startGame.js"></script>
		<script src="newGame.js"></script>
		<script src="joinGame.js"></script>
		<script src="ErrorManager.js"></script>
	</body>
</html>