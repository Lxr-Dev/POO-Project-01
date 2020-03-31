<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="gameHandler.*" %>
<%@ page import="unoDeck.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	if(request.getParameter("option") != null){
		
		ActionCard ac = new ActionCard();  
		
		if(request.getParameter("option").toString().trim().matches("^throw$")){	
		
			if(request.getParameter("cookies") != null && request.getParameter("index") != null &&  request.getParameter("currentColor") != null && request.getParameter("currentValue") != null){
				
				FileManager fm = new FileManager();
				Converter c = new Converter();
				int index = Integer.parseInt((request.getParameter("index").toString().trim()));
				List<Card> lst = new ArrayList<>();
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
	    		
				if(ac.verifyTurn(player, code)){
						lst = c.toCardList(fm.Read(c.playerPath(c.GetPlayerValue(player), code)));
						boolean result = false;
	    				if(lst.get(index).getValue() < 10){
	    					result = ac.ThrowNumericCard(player, code, index);
	    				}	
	    				else if(lst.get(index).getValue() == 10){
	    					ac.plusTwo(player,code,index);	
	    					result = true;
	    				}
	    				else if (lst.get(index).getValue() == 11){
	    					result = ac.Reverse(player,code,index);
	    				}
	    				else if (lst.get(index).getValue() == 12){
	    					result = ac.Block(player,code,index);
	    				}
	    				else if (lst.get(index).getValue() == 13){
	    					ac.plusFour(player,code,index);
	    					result = true;
	    				}
	    				else if (lst.get(index).getValue() == 14){
	    					ac.changeColor(player,code,index);
	    					result =  true;
	    				}
	    				boolean win = ac.WinnerPlayer(player,code);
	    				out.print(String.format("{\"winner\":%s,\"status\":%s",win,result? "true}":"false,\"message\":\"Carta Inválida\"}"));		
						
				}
				else out.print("{\"status\":false,\"message\":\"No es tu Turno\"}");
			}
		}
		
		else if(request.getParameter("option").toString().trim().matches("^draw$")) {
			
			if(request.getParameter("cookies") != null &&  request.getParameter("currentColor") != null &&  request.getParameter("currentValue") != null){				
					String[] cookies = request.getParameter("cookies").toString().split(";");
		    		String code = "";
		    		String player = "";
	
		    		
		    		if (cookies[0].matches("(player=)\\d")){
		    			player = cookies[0].trim().replace("player=","");
		    			code = cookies[1].trim().replaceAll("code=",""); 
		    		}
		    		else{
		    			player = cookies[1].trim().replaceAll("player=","");
		    			code = cookies[0].trim().replaceAll("code=","");
		    		}
		    		
		    		if (ac.verifyTurn(player,code)) out.print(ac.draw(player,code,request.getParameter("currentColor"),request.getParameter("currentValue")));
		    		else out.print("{\"status\":false,\"message\":\"No es su Turno\"}");
			}
		} else if(request.getParameter("option").toString().trim().matches("^changeColor$")){
				
			if(request.getParameter("cookies") != null &&  request.getParameter("currentColor") != null){				
					String[] cookies = request.getParameter("cookies").toString().split(";");
		    		String code = "";
		    		String player = "";
	
		    		
		    		if (cookies[0].matches("(player=)\\d")){
		    			player = cookies[0].trim().replace("player=","");
		    			code = cookies[1].trim().replaceAll("code=",""); 
		    		}
		    		else{
		    			player = cookies[1].trim().replaceAll("player=","");
		    			code = cookies[0].trim().replaceAll("code=","");
		    		}
		    		
		    		if (ac.verifyTurn(player, code)){
		    			ac.newColor(player, request.getParameter("currentColor"), code);
		    			out.print("{\"status\":true}");
		    		}else{
		    			out.print("{\"status\":false}");
		    		}
			}
		
		else out.print("{\"status\":false}");
	}
}
%>