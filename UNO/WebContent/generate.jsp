<%@ page import="unoDeck.Player" %>
<%@ page import="unoDeck.Deck" %>
<%@ page import="unoDeck.Card" %>
<%@ page import="java.util.List" %>
<%@ page import="gameHandler.*" %>
<%@ page import="unoDeck.Converter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	
    if (request.getParameter("gamerTag")!=null && request.getParameter("gamerTag").toString().length() >1 ){
    	Deck deck = new Deck();
    	deck.generateDeck();
    	List<List<Card>> decks = deck.deal();
    	
    	Player p1 = new Player(request.getParameter("gamerTag").toString().trim(),decks.get(0));
    	FileManager fm = new FileManager();
    	Converter cv = new Converter();
    	
    	String code = fm.Mkdir();
    	fm.Write(String.format("%s/player1.json",code),cv.toJSONString(p1.getDeck()));
    	fm.Write(String.format("%s/player2.json",code),cv.toJSONString(decks.get(1)));
    	fm.Write(String.format("%s/graveyard.json",code),cv.toJSONString(decks.get(2)));
    	fm.Write(String.format("%s/Deck.json",code),cv.toJSONString(decks.get(3)));
    	
    	out.print(code);
    	
    	
    }else{
    	out.print("NO CHAVAL F");
    }
%>