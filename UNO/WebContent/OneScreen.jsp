<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
out.print("<link rel='stylesheet' href='GameStyle.css'>"
+"<div id='contenedorPrincipal'>");
//agregar String.format y en los valores p# y op# el numeral se cambia por el numero de un contador = total de cartas
//
out.print("<section id='oponent_cards'><div class='hideCard' id='op1'><img class='logo' src='logo.png'></div></section>"
		+"<section id='deck'><div class='hideCard' id='UnoDeck'><img class='logo' src='logo.png'></div>"
		+"<div class='contenedor2' id='Cementery'><img class='' src=''><p class='texto'>Cementery</p></div></section>"
		+"<section id='player_cards'><div class='contenedor' id='p1'><img class='' src=''><p class='texto'>carta1</p></div></section></div>");
%>
</body>
</html>