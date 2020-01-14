<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Miscellaneous JSP Examples</title>
</head>
<body>

<h5>Including file using directive element (Used for including static content file ) : </h5>
<%@ include file="demoFile.txt" %>
</br>
<h5>Including file using jsp tag, page attribute (Used for including dynamic content file) : </h5>
<jsp:include page="demoFile2.txt"/>

</br>
<h5>Imported Date class using import attribute ( page import=\"<class to be imported>")</h5>
<%@ page import="java.util.Date" %>

<%= new Date() %>


</body>
</html>