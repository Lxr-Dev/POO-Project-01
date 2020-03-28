<%@page import="java.util.Random"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@page import="java.util.List"%>
    <%@ page import="gameHandler.*" %>
    <%@ page import="unoDeck.*" %>
<% 
	if(request.getParameter("option") != null){
		
		if(request.getParameter("option").toString().trim().matches("^throw$")){
			if(request.getParameter("cookies") != null &&
			   request.getParameter("index") != null && 
			   request.getParameter("currentColor") != null && 
			   request.getParameter("currentValue") != null){
				
				FileManager fm = new FileManager();
				Converter c = new Converter();
				int index = Integer.parseInt((request.getParameter("index").toString().trim()));
				List<Card> lst = new ArrayList<>();
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

	    		if (player.equals("1")){
	    			
	    			lst = c.toCardList(fm.Read(String.format("%s/player1.json",code)).trim());
	    			
	    			
	    			if (lst.get(index).getValue() == Integer.parseInt(request.getParameter("currentValue").toString()) || lst.get(index).getColor() == Integer.parseInt(request.getParameter("currentColor").toString())){ 				
	    				
	    				if(lst.get(index).getValue() == 10){
	    					ac.plusTwo(player,code,Integer.parseInt(request.getParameter("index").toString()));	
	    				}
	    				else{
	    					ac.ThrowNumericCard(player,code,Integer.parseInt(request.getParameter("index").toString()));
	    				}  
	    				out.print("{\"status\":true}");
	    			}
	    			
	    			else if(lst.get(index).getValue() == 13){
    					ac.plusFour(player,code,Integer.parseInt(request.getParameter("index").toString()));
	    			}
	    		}
	    		else{	    			
	    			
	    			lst = c.toCardList(fm.Read(String.format("%s/player2.json",code)).trim());
	    			
	    			if (lst.get(index).getValue() == Integer.parseInt(request.getParameter("currentValue").toString()) || lst.get(index).getColor() == Integer.parseInt(request.getParameter("currentColor").toString())){ 				
	    				
	    				if(lst.get(index).getValue() == 10){
	    					ac.plusTwo(player,code,Integer.parseInt(request.getParameter("index").toString()));	
	    				}
	    				else{
	    					ac.ThrowNumericCard(player,code,Integer.parseInt(request.getParameter("index").toString()));
	    				}  
	    				out.print("{\"status\":true}");
	    			}
	    			
	    			else if(lst.get(index).getValue() == 13){
    					ac.plusFour(player,code,Integer.parseInt(request.getParameter("index").toString()));
	    			}
	    		}
			}
		}
		else if(request.getParameter("option").toString().trim().matches("^draw$")) {
			
			if(request.getParameter("cookies") != null && 
					   request.getParameter("currentColor") != null && 
					   request.getParameter("currentValue") != null){
						
						FileManager fm = new FileManager();
						Converter c = new Converter();
						List<Card> mainDeck = new ArrayList<>();
						List<Card> playerDeck = new ArrayList<>();
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
			    		
			    		mainDeck = c.toCardList(fm.Read(String.format("%s/Deck.json",code)));	    		
			    		
			    		
			    		
			    		Random rand = new Random();
			    		int i = rand.nextInt(mainDeck.size());
			    		Card drawCard = mainDeck.get(i);
			    		mainDeck.remove(i);


			    		if (player.equals("1")){			    			
				    		playerDeck = c.toCardList(fm.Read(String.format("%s/player1.json",code)));
				    		playerDeck.add(drawCard);

		    				fm.Write(String.format("%s/player1.json", code),c.toJSONString(playerDeck));
		    				fm.Write(String.format("%s/Deck.json", code),c.toJSONString(mainDeck));
		    				
		    				out.print("{\"status\":true}");
			    		}
			    		else{
			    			playerDeck = c.toCardList(fm.Read(String.format("%s/player2.json",code)));
				    		playerDeck.add(drawCard);

		    				fm.Write(String.format("%s/player2.json", code),c.toJSONString(playerDeck));
		    				fm.Write(String.format("%s/Deck.json", code),c.toJSONString(mainDeck));
		    				
		    				out.print("{\"status\":true}");
			    		}
			}
		}
		else{
			out.print("{\"status\":false}");
		}
	}	
%>