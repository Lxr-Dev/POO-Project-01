<%@ page import="gameHandler.FileManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%
    if (request.getParameter("code")!= null){
    	FileManager fm = new FileManager();
    	String result = "{\"status\":false,\"message\":\"F El código no existe\"}";
    	String[] codes = fm.Read("codes.db").split("\n");
    	
    	for (String code : codes){
    		if (code.trim().equals(request.getParameter("code").toString().trim())){
    			result = (String.format("{\"status\":true,\"message\":\"Encontramos el código %s\"}",code));
    			break;
    		}
    	}
    		
    	out.print(result);
    		
    }
    %>