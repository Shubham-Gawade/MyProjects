<%@page import="com.Model.CreateAccount"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="design1.css">
<title>Insert title here</title>
</head>
<body>
	<div id="d1"><h3 style="text-align: center;">List of All Accounts</h3></div>
	<%!List<CreateAccount> lst; %>
	
	<%
		if(!session.isNew())
		{
			lst=(List<CreateAccount>)session.getAttribute("Alldata");
			session.invalidate();
	%>
	<table border="3" align="center">
	<tr>
		<td>First name</td>
		<td>Last name</td>
		<td>Gender</td>
		<td>DateOfBirth</td>
		<td>Area</td>
		<td>State</td>
		<td>City</td>
		<td>PinCode</td>
		<td>Nationality</td>
		<td>AdharCardNo</td>
		<td>MobileNo</td>
		<td>EmailId</td>
		<td>UserId</td>
		<td>AccType</td>
		<td>BranchName</td>
		<td>Valid</td>
		<td>Invalid</td>
	</tr>
	<%
		for(CreateAccount a:lst){
	%>
	<tr>
		<td><%=a.getFirstName() %></td>
		<td><%=a.getLastName() %></td>
		<td><%=a.getGender() %></td>
		<td><%=a.getDateOfBirth() %></td>
		<td><%=a.getArea() %>
		<td><%=a.getCity() %></td>
		<td><%=a.getState() %></td>
		<td><%=a.getPinCode() %></td>
		<td><%=a.getNationality() %></td>
		<td><%=a.getAdharNo() %></td>
		<td><%=a.getMobileNo() %></td>
		<td><%=a.getEmailId() %></td>
		<td><%=a.getUserId() %></td>
		<td><%=a.getAccType() %></td>
		<td><%=a.getBranchName() %></td>
		<td><a href="ValidAccountController">Valid</a></td>
		<td><a href="InvalidAccountController">Invalid</a></td>
	</tr>
	<%
		}
	%>
	</table>
	<%
		}
	%>
	<h3 style="text-align: center;"><a href="AdminDatabaseDisplay.jsp">HomePage</a></h3>
</body>
</html>