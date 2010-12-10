<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Login</title>

<script type="text/javascript" language="JavaScript">
	function submitlogin(){
		document.forms["loginform"].submit();
	}
</script>

</head>
<body>
	<form id="loginform" action="UsersController?actionType=login" method="post">
		<table cellpadding="0" cellspacing="0" border="0" align="center">
			<tr>
				<td align="center" colspan="2"><h1>Login</h1></td>
			</tr>
			<tr>
				<td align="left">
					<b>Username: </b>
				</td>
				<td align="left">
					<input type="text" name="txtUser" width="90px" />
				</td>
			</tr>
			<tr>
				<td align="left">
					<b>Password: </b>
				</td>
				<td align="left">
					<input type="password" name="txtPass" width="90px"/>
				</td>
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="button" value="Submit" name="btnSubmit" onclick="submitlogin()"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>