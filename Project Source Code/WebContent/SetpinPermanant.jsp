<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.header{
	padding: 14px;
	text-align:center;
	background:#6c6cf2;
	color:#ffffff;
	font-size: 15px;
	font-weight:bold;

}
.topright{
	position:absolute;
	top:8px;
	right:16px;
	font-size:18px;
	color:white;
	
	
}

</style>
<body>
<%@include file="repeat.jsp" %>
<div class="header">
<form action="LogoutController">
		<h1 style="text-align: center;"><input type="submit" name="save" value="Logout" class="btn" style="float: left"></h1><br>
</form>
<h2>Fund Transaction</h2>
</div>
<%@include file="SideNavigation.jsp" %>
<center>
<form action="SetPinController" method="post">
<table>

<tr>
	<td><h3>Create Your Own Pin:</h3></td>
	<td><input type="password" name="pin" size="30" autocomplete="off"></td><br><br>
</tr>
<tr>
	<td><h3>Conform Own Pin:</h3></td>
	<td><input type="password" name="confpin" size="30" autocomplete="off"></td><br><br>
</tr>

</table>
			<br><br>
			
		<h1 style="text-align: center;"><input type="submit" name="save" value="Ok" class="btn"></h1>
</form>
		   
					

</center>

</body>
</html>