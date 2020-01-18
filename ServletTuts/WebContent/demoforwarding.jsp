<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo:Forwarding</title>
</head>
<body>
<h4>This is from source page.</h4>

<!--<jsp:forward page="forward.jsp"></jsp:forward>-->

<% 
	request.getRequestDispatcher("forward.jsp").forward(request, response);
%>

</body>
</html>