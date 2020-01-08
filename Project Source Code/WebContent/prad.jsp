<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
    <%@page import="java.util.List"%>
    <%@page import="com.Model.DisplayProfile"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="d1"><h3 style="text-align: center;">My Profile</h3></div>
	<%!List<DisplayProfile> lst; %>
	<%
		if(!session.isNew())
		{
			lst=(List<DisplayProfile>)session.getAttribute("AllvalidAcc");
	%>
	<table border="3" align="center">
	<tr>
		<td>User Id</td>
		<td>Account No</td>
		<td>First name</td>
		<td>Last name</td>
		<td>EmailId</td>
		<td>MobileNo</td>
		<td>AccType</td>
		<td>Account Bal</td>
		<td>BranchName</td>
		<td>IFSC_Code</td>
	</tr>
	<%
		for(DisplayProfile a:lst){
	%>
	<tr>
		<td><%=a.getUserId() %></td>
		<td><%=a.getAccNo() %></td>
		<td><%=a.getFname() %></td>
		<td><%=a.getLname() %></td>
		<td><%=a.getEmail() %></td>
		<td><%=a.getMobile() %></td>
		<td><%=a.getAccType() %>
		<td><%=a.getAccBal() %></td>
		<td><%=a.getBranchName() %></td>
		<td><%=a.getIfscCode() %></td>
	</tr>
	<%
		}
	%>
	</table>
	<form action="Welcome.jsp">
			<h1 style="text-align: center;"><input type="submit" name="save" value="OK"></h1>
	</form>
	<%
		}
	%>
</body>
</html>