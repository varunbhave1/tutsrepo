<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo:Redirection</title>
</head>
<body>
<h4>Source page for redirection.</h4>
<%
	response.sendRedirect("redirect.jsp");
%>
</body>
</html>