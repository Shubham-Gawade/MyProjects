<%@ include file="SideNavigation.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<link rel="stylesheet" href="tabledesign.css">

<body>
<div class="header">Change Transaction Pin
</div>
<br>
<br>
<%@include file="repeat.jsp" %>
<form action="ChangePinController" method="post">

<center>
	
	<table>
	<tr>
	
	<td>Enter new Transaction pin</td>

	<td><input type="password" pattern="[0-9]{4}" title="Only 4 digits" name="epin" class="resizedTextbox" autocomplete="off"></td>
	</tr>
	<tr>
	<td>Confirm Transaction pin</td>
	<td><input type="password" pattern="[0-9]{4}" title="Only 4 digits" name="cpin" class="resizedTextbox" autocomplete="off">
	
	</tr>
	</table>
	<br>
	<input type="submit" id="submit" value="Change TransactionPin">
	<br>
	<br>

	<h1><a href="Setting.jsp">Back to Setting Page!!</h1></a>
	</center>

</form>
</body>
</html>