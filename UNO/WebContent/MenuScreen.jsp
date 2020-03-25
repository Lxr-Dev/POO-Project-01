<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' type='text/css' href='MenuStyle.css'>
<link rel='stylesheet' type='text/css' href='popupStyle.css'>
</head>
<body>
<%
out.println("<div id='menuBtns' class='bg-dark btn-container border'><div id='oneLogo' class='logo'></div>"
+"<div id='btn1'><a href='#' id='abrir1' class='btn-ghost red '>Nueva Partida</a></div>"
+"<div id='btn2'><a href='#' id='abrir2' class='btn-ghost orange'>Ingresar </a></div>"
+"<div id='btn3'><a href='#' id='abrir3' class='btn-ghost green'>Scores</a></div>"
+"<div id='btn4'><a href='#' id='abrir4' class='btn-ghost lilac '>creditos</a></div>"
+"<div id='miModal' class='modal'><div class='flex' id='flex'><div class='contenido-modal'> "
+"<div class='modal-header flex'><span class='close' id='close'>&times</span>"
+"</div><div class='modal-body'><h4>INGRESAR CODIGO</h4><form action='OneScreen.jsp'>"
+"<input id='contenedor-input' type='text' placeholder='ingrese codigo de acceso'><br><input type='submit' class='btn-submit' value='Ingresar'>"
+"</form></div></div></div></div>");

%>
<script src="popup.js"></script>
</body>
</html>
