<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.Model.Transaction"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="d1"><h3 style="text-align: center;">List of All Transactions</h3></div>
	<%!List<Transaction> lst; %>
	
	<%
		if(!session.isNew())
		{
			lst=(List<Transaction>)session.getAttribute("AllTransaction");
			session.invalidate();
	%>
	<table border="3" align="center">
	<tr>
		<td>Transaction Id</td>
		<td>Customer Id</td>
		<td>Amount</td>
		<td>Date of Transaction</td>
		<td>Status</td>
		<td>Discription</td>
	</tr>
	<%
		for(Transaction a:lst){
	%>
	<tr>
		<td><%=a.getTransactionId() %></td>
		<td><%=a.getCustomerId() %></td>
		<td><%=a.getAmount() %></td>
		<td><%=a.getDateOftransaction() %></td>
		<td><%=a.getStatus() %></td>
		<td><%=a.getDiscription() %></td>
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