<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="unoDeck.*"%>
<%@page import="gameHandler.IdManager" %>
<%@page import="gameHandler.Start" %>
<%@page import="java.util.List"%>
<%@page import="gameHandler.FileManager" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Service</title>
	</head>
	<body>
	<%
	Player player1 = new Player("name1");
	Player player2 = new Player("name2");
	
	Start partida1 = new Start(player1, player2);
	
int w=0, x=0, y=0, z=0;
	
	out.print("Las cartas del Player 1 son:<br><br>");
	for (Card c: partida1.getPlayer1().getDeck()){
		w++;
		out.println(String.format("<p>Value = %s color=%s type = %s</p>",c.getValue(),c.getColor(),c.getType()));
	}
	out.print(String.format("<br>Total de Cartas = %s<br>",w));
	
	out.print("<br><br>Las cartas del Player 2 son:<br><br>");
	for (Card c: partida1.getPlayer2().getDeck()){
		x++;
		out.println(String.format("<p>Value = %s color=%s type = %s</p>",c.getValue(),c.getColor(),c.getType()));
	}
	out.print(String.format("<br>Total de Cartas = %s<br>",x));
	
	out.print("<br><br>Las cartas del Cementerio son:<br><br>");
	for (Card c : partida1.getGraveyard().getCard()){
		y++;
		out.println(String.format("<p>Value = %s color=%s type = %s</p>",c.getValue(),c.getColor(),c.getType()));
	}
	out.print(String.format("<br>Total de Cartas = %s<br>",y));
	
	out.print("<br><br>Las cartas del Deck Principal son:<br><br>");
	for (Card c : partida1.getPrincipal().getCard()){
		z++;
		out.println(String.format("<p>card = %s Value = %s color=%s type = %s img = %s</p>", z, c.getValue(),c.getColor(),c.getType(), c.getImg()));
	}
	out.print(String.format("<br>Total de Cartas = %s<br>",z));
	
	Converter c = new Converter();
	String h1 = c.toJSONString(partida1.getPrincipal().getCard());
	out.print("<br>"+h1+"<br>");
	List<Card> l1 = c.toCardList(h1);
	
	for (Card t : l1){
		out.println(String.format("<p>Value = %s color=%s type = %s</p>",t.getValue(),t.getColor(),t.getType()));
	}
	
	FileManager fm = new FileManager();
	fm.Mkdir();
	out.println(fm.Folders());
	out.println(fm.Games());
	
	%>
	</body>
</html>