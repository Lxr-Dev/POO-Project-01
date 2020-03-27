<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="gameHandler.FileManager" %>
<% 
	if(request.getParameter("cookies") != null && request.getParameter("index") != null){
		
		FileManager fm = new FileManager();
	}
%>