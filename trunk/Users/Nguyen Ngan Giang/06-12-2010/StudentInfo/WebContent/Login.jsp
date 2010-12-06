<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="LoginProcessing" method="post" name="LoginServlet">
		<h1>Login</h1>
		Username : <input name="txtUser" type="text"/><br/>
		Password : <input name="txtPass" type="password"/><br/>
		<input name="btnLogin" value="Login" type="submit"/>
	</form>
</body>
</html>