<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Scriptlet Elements</title>
</head>
<body>
	<h1>Hello JSP !</h1>
	<h4>Expression element:</h4>
	<%=new String("Expressions String") %>
	
	<h4>Scriptlet Element : </h4>
	<%
		out.println("Looping till 10:</br>");
		for(int i=1;i<=10;i++){
			out.print(i);
			out.print("</br>");
		}
	%>
	
	<h4>Declaration Elements</h4>
	<p>Unlike scriptlets , it allows access specifiers.</p>
	<p>Main purpose is to declare methods.</p>
	<%!
		public String printMessage(String message){
			return "Message : "+message;
		}
	%>
	
	<%= printMessage("JSP Tuts => declarative element !") %>
	
	</body>
</html>