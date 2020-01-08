<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="SideNavigation.jsp" %>
	<table>
		<tr>
		<td>
		<form action="MyProfileController" method="post" >
			<h1 style="text-align: center;"><input type="submit" name="save" value="My Profile" class="btn" style="float: left"></h1><br>
		</form>
		</td>
		</tr>
		<tr>
		<td>
		<form action="FundTransferController" method="post">
			<h1 style="text-align: center;"><input type="submit" name="save" value="Fund Transfer" class="btn" style="float: left"></h1><br>
		</form>
		</td>
		</tr>
		<tr>
		<td>
		<form action="Setting.jsp">
			<h1 style="text-align: center;"><input type="submit" name="save" value="Setting" class="btn" style="float: left"></h1><br>
		</form>
		</td>
		<tr>
		<td>
		<form action="Help.jsp">
			<h1 style="text-align: center;"><input type="submit" name="save" value="Help" class="btn" style="float: left"></h1><br>
		</form>
		</td>
		</tr>
		</td>
		</tr>
		</table>
</body>
</html>