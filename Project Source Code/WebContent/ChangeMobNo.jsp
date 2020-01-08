<%@ include file="SideNavigation.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="tabledesign.css">

</head>
<body>
<div class="header">Change Phone Number
</div>
<br>
<br>
<%@include file="repeat.jsp" %>
<form action="ChangeMobNoController" method="post">

<center>
	
	<table>
	<tr>
	
	<td>Enter new Phone No.</td>

	<td><input type="text" pattern="[789][0-9]{9}" name="emob" class="resizedTextbox" title="phone no. must be of 10 digit and always start from 7 or 8 or 9" autocomplete="off"></td>
	</tr>
	<tr>
	<td>Confirm Phone No.</td>
	<td><input type="text" pattern="[789][0-9]{9}" name="cmob" class="resizedTextbox" title="phone no. must be of 10 digit and always start from 7 or 8 or 9" autocomplete="off"></td>
	
	</tr>
	</table>
	<br>
	<input type="submit" id="submit" value="Change Phone No.">
	<br>
	<br>

	<h1><a href="Setting.jsp">Back to Setting Page!!</h1></a>
	</center>

</form>
</body>
</html>