<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>UNO &copy;</title>
		<link rel="shortcut icon" href="Resources/favicon.png"/>
		<link rel='stylesheet' type='text/css' href='CSS/MenuStyle.css'>
		<link rel='stylesheet' type='text/css' href='CSS/popupStyle.css'>
	</head>
	<body>
		<%
		out.println(
		"<div id='menuBtns' class='bg-dark btn-container border'><div id='oneLogo' class='logo'></div>"
		+"<div id='btn1'><a id='abrir1' class='btn-ghost red '>Nueva Partida</a></div>" 
		+"<div id='btn2'><a id='abrir2' class='btn-ghost orange'>Ingresar a partida </a></div>"
		+"<div id='btn3'><a id='abrir3' class='btn-ghost green'>Scores</a></div>"
		+"<div id='btn4'><a id='abrir4' class='btn-ghost lilac '>creditos</a></div>"
		+"<div id='miModal' class='modal'><div class='flex' id='flex'><div class='contenido-modal'> "
		+"<div class='modal-header flex'><span class='close' id='close'>&times</span>"
		+"</div><div id='message'class='modal-body'></div></div></div></div>");
		%>
		<script src="Javascript/jquery.js"></script>
		<script src="Javascript/ErrorManager.js"></script>
		<script src="Javascript/newGame.js"></script>
		<script src="Javascript/startGame.js"></script>
		<script src="Javascript/joinGame.js"></script>
		<script src="Javascript/popup.js"></script>
	</body>
</html>
