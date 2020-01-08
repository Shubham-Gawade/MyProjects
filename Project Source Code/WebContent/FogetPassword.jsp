<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="id1">
			<h2 style="text-align: center;">Forget Password Page</h2>
		</div>
		<form action="ForgetPasswordController" method="post">
		<table align="center">
			<tr>
				<td>Enter Username : </td>
				<td><input type="text" name="uname" autocomplete="off" required ></td>
			</tr>
			<tr>
				<td>Enter Email id : </td>
				<td><input type="text" name="email" autocomplete="off" required></td>
			</tr>
		</table>
			<h1 style="text-align: center;"><input type="submit" name="save" value="Submit"></h1>
		</form>
</body>
</html>