<%@ page import="gameHandler.FileManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    
    	if (request.getParameter("cookies")!=null){
    		
    		StringBuilder result = new StringBuilder();
    		FileManager fm = new FileManager();
    		
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
    		
    		if (player.equals("1")){
    			result.append(fm.Read(String.format("%s/player1.json",code)));
    		}else{
    			result.append(fm.Read(String.format("%s/player2.json",code)));
    		}
    		
    		out.print(result.toString());
    	}
    %>