<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
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
<div class="header">
<form action="LogoutController">
		<h1 style="text-align: center;"><input type="submit" name="save" value="Logout" class="btn" style="float: left"></h1><br>
</form>

<h2>Fund Transaction</h2>
</div>
<br>
<%@include file="SideNavigation.jsp" %>
<%@include file="repeat.jsp" %>

<center>
<table>


<tr>
<td>	     <a href="IntraBankingTransfer.jsp" class="btn">With In Same Bank</a></td><br><br>




</tr>
</table>


</table>
</center>

</body>
</html>