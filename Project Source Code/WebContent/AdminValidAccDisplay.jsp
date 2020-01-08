<%@page import="com.Model.DisplayAllData"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="d1"><h3 style="text-align: center;">List of All Accounts</h3></div>
	<%!List<DisplayAllData> lst; %>
	
	<%
		if(!session.isNew())
		{
			lst=(List<DisplayAllData>)session.getAttribute("AllvalidAcc");
			session.invalidate();
	%>
	<table border="3" align="center">
	<tr>
		<td>Customer Id</td>
		<td>User Id</td>
		<td>Account No</td>
		<td>First name</td>
		<td>Last name</td>
		<td>DateOfBirth</td>
		<td>Gender</td>
		<td>Area</td>
		<td>City</td>
		<td>State</td>
		<td>PinCode</td>
		<td>Nationality</td>
		<td>AdharCardNo</td>
		<td>EmailId</td>
		<td>MobileNo</td>
		<td>AccType</td>
		<td>Account Bal</td>
		<td>BranchName</td>
	</tr>
	<%
		for(DisplayAllData a:lst){
	%>
	<tr>
		<td><%=a.getCustomerId() %></td>
		<td><%=a.getUserId() %></td>
		<td><%=a.getAccno() %></td>
		<td><%=a.getFirstName() %></td>
		<td><%=a.getLastName() %></td>
		<td><%=a.getDob() %></td>
		<td><%=a.getGender() %></td>
		<td><%=a.getArea() %>
		<td><%=a.getCity() %></td>
		<td><%=a.getState() %></td>
		<td><%=a.getPinCode()%></td>
		<td><%=a.getNationality() %></td>
		<td><%=a.getAdharNo() %></td>
		<td><%=a.getEmail() %></td>
		<td><%=a.getMobNo() %></td>
		<td><%=a.getAccountType() %></td>
		<td><%=a.getAccBal() %></td>
		<td><%=a.getBranchName() %></td>
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