<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form & Controller</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/formcontroller" method="post">

	Full Name		: 	<input type="text" name="name"><br/><br/>
	Gender	        : 	<input type="radio" name="gender" value="Male"> Male
			   			<input type="radio" name="gender" value="Female"> Female<br/><br/>
	Languages Known : 	<input type="checkbox" name="language" value="Hindi">Hindi
						<input type="checkbox" name="language" value="English">English
						<input type="checkbox" name="language" value="French">French<br/><br/>
	Country			: 	<select name="country">
							<option value="INDIA">INDIA</option>
							<option value="USA">USA</option>
							<option value="CANADA">CANADA</option>
						</select><br/><br/>
						<input type="submit" value="SUBMIT">		   

</form>

</body>
</html>