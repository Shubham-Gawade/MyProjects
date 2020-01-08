<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head><style>
.header{
	padding: 14px;
	text-align:center;
	background:#6c6cf2;
	color:#ffffff;
	font-size: 14px;
	font-weight:bold;

}
.lower-container{
	height:400px;
	background: #fff;
	padding:70px;
	padding-top:129px;
	padding-left:60px;
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
<div class="topright"><span class="glyphicon glyphicon-log-out"><a href="Logout.jsp" style="color:red">LogOut</a></span></div>
<h2>Fund Transaction</h2>
</div>
<br>
<%@include file="repeat.jsp" %>
<%@include file="SideNavigation.jsp" %>
<center>
<div class=".lower-container">

<h2>Money Transfered Successfully !!!!</h2>
 <a href="Welcome.jsp" class="btn">OK</a></td><br><br>
</div>
</center>
</body>
</html>