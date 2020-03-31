<%@ page import="gameHandler.ActionCard" %>
<%@ page import="gameHandler.FileManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
	
    if (request.getParameter("option") != null){
    	
    	if (
    		request.getParameter("option").toString().trim().matches("^add$") &&
    		request.getParameter("gamerTag") != null &&
    		request.getParameter("score") != null
    	){
    		FileManager fm = new FileManager();
    		
    		String gamerTag = request.getParameter("gamerTag").toString().trim();
    		String score = request.getParameter("score").toString().trim();
    		
    		fm.Write("winners.csv",String.format("%s%s,%s",fm.Read("winners.csv"),gamerTag,score));
    		
    		out.print("{\"status\":true}");
    		
    	}else if (
    			request.getParameter("option").toString().trim().matches("^getScore$") && 
    			request.getParameter("cookies") != null
    		){
    		
    		ActionCard ac = new ActionCard();
    		
    		String[] cookies = request.getParameter("cookies").toString().split(";");
    		String code = "";
    		String player = "";
    		
    		if (cookies[0].matches("(player=)\\d")){
    			player = cookies[0].trim().replace("player=","");
    			code = cookies[1].trim().replaceAll("code=","");
    		}else{
    			player = cookies[1].trim().replaceAll("player=","");
    			code = cookies[0].trim().replaceAll("code=","");
    		}
    		
    		String score;
    		
    		if (player.equals("1")){
    			score = ac.calculateScore("2", code);
    		}else{
    			score = ac.calculateScore("1",code);
    		}
    		
    		out.print(String.format("{\"status\":true,\"score\":\"%s\"}",score));	
    		
    	}else{
    		out.print("{\"status\":false,\"message\":\"Opción no Válida\"}");	
    	}
    	
    }else{
    	out.print("{\"status\":false,\"message\":\"Parámetro Vacío\"}");
    }
%>