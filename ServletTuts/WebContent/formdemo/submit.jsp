<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Submitted Info</title>
</head>
<body>
<h4>Information Submitted by user : </h4>
Name				: <%= request.getParameter("name") %><br/>
Gender				: <%= request.getParameter("gender") %><br/>
Languages Known		: <%
		String countries[]=request.getParameterValues("language");
		String selected="";
		if(countries !=null && countries.length>0){
			selected = String.join(",", countries);
			out.print(selected);
		}else{
			out.print("known languages not selected !");
			}
		
%><br/>
Country				: <%= request.getParameter("country") %><br/>
</body>
</html>