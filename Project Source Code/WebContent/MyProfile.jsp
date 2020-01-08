<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.List"%>
    <%@page import="com.Model.DisplayProfile"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="top">
</div>

<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>

<div class="header">

<form action="LogoutController">
		<h1 style="text-align: center;"><input type="submit" name="save" value="Logout" class="btn" style="float: left"></h1><br>
</form>
<h2>My Profile</h2>
</div>
<link rel="stylesheet" type="text/css" href="profile.css">
</head>
<body>
<%@include file="repeat.jsp" %>
	<%!List<DisplayProfile> lst; %>
	
	<%
		if(!session.isNew())
		{
			lst=(List<DisplayProfile>)session.getAttribute("AllvalidAcc");
	%>
<%@include file="SideNavigation.jsp" %>

<div class="card-container">
<div class="upper-container">
<div class="image-container">
	<img src="logo1.jpg"/>
</div>
</div>

<div class="lower-container">
	<%
		for(DisplayProfile a:lst){
	%>
		<h3 align="right"> <%=a.getFname() %> <%=a.getLname() %></h3>
		
	    <h3>UserID: <%=a.getUserId() %></h3>
	    <h3>Email ID: <%=a.getEmail() %></h3>
	    <h3>Mobile No.: <%=a.getMobile() %></h3>
	    <h3>Account No: <%=a.getAccNo() %></h3>
	    <h3>Account Type: <%=a.getAccType() %></h3>
	    <h3>Balance: <%=a.getAccBal() %></h3>
	    <h3>Branch: <%=a.getBranchName() %></h3>
	    <h3>IFSC Code: <%=a.getIfscCode() %></h3>
	
	<%
		}
	%>
	<form action="Welcome.jsp">
			<h4 style="text-align: center;"><input type="submit" name="save" value="Go to Dashboard" class="btn"></h1>
	</form>
<%
	}
	%>
</div>
</div>

</body>
</html>