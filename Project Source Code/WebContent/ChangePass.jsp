<%@ include file="SideNavigation.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function nospacetxt(x)
{
	if((x.keyCode == 32))
		{
			alert("No space allowed");
			return false;
		}
	return true;
}	
</script>

<link rel="stylesheet" href="tabledesign.css">

</head>
<body>
<div class="header">Change Password
</div>
<br>
<br>
<%@include file="repeat.jsp" %>
<form action="ChangePassController" method="post">

<center>
	
	<table>
	<tr>
	
	<td>Enter new Password</td>

	<td><input type="password" name="epass" class="resizedTextbox" onkeydown="return nospacetxt(event)" autocomplete="off"></td>
	</tr>
	<tr>
	<td>Confirm Password</td>
	<td><input type="password" name="cpass" class="resizedTextbox" onkeydown="return nospacetxt(event)" autocomplete="off">
	
	</tr>
	</table>
	<br>
	<input type="submit" id="submit" value="Change Password">
	<br>
	<br>

	<h1><a href="Setting.jsp">Back to Setting Page!!</h1></a>
	</center>

</form>
</body>
</html>