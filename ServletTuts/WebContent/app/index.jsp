<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<h3>Menu : </h3>
<a href="<%=request.getContextPath()%>/controller?page=login">Login</a><br/>
<a href="<%=request.getContextPath() %>/controller?page=signup">SignUp</a><br/>
<a href="<%=request.getContextPath() %>/controller?page=about">About</a><br/>
</body>
</html>