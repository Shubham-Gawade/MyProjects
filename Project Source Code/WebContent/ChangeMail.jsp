<%@ include file="SideNavigation.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</style>
<link rel="stylesheet" href="tabledesign.css">

</head>
<body>
<div class="header">Change Email-Id
</div>
<br>
<br>
<%@include file="repeat.jsp" %>
<form action="ChangeMailController" method="post">

<center>
	
	<table>
	<tr>
	
	<td>Enter new Email-Id</td>

	<td><input type="text" pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name="email" class="resizedTextbox" title="Email-id must be in format characters@characters.domain(for eg:name@gmail.com)" autocomplete="off"></td>
	</tr>
	<tr>
	<td>Confirm Email-Id</td>
	<td><input type="text" pattern="[a-zA-Z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" name="cmail" class="resizedTextbox" title="Email-id must be in format characters@characters.domain(for eg:name@gmail.com)" autocomplete="off">
	
	</tr>
	</table>
	<br>
	<input type="submit" id="submit" value="Change Email-Id">
	<br>
	<br>

	<h1><a href="Setting.jsp">Back to Setting Page!!</h1></a>
	</center>

</form>
</body>
</html>