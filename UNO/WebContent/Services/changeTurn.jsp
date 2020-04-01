<%@ page import="gameHandler.FileManager" %>
<%@ page import="gameHandler.ActionCard" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("cookies") != null ){
		
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
		
		
		if(player.trim().equals(fm.Read(String.format("%s/turn.txt",code)).toString().replaceAll("\n", ""))){			
			ActionCard  ac = new ActionCard();
			if(ac.ChanginColor(code) == true){				
				out.print("{\"yourTurn\":true,\"changin\":true}");
			}
			else {
				out.print("{\"yourTurn\":true,\"changin\":false}");
			}
		}
		else{
			out.print("{\"yourTurn\":false,\"changin\":false}");
		}
		
	}
%>