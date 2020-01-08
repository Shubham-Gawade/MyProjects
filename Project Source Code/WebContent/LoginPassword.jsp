<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
.btn{
	padding:15px 20px;
	background:#7f00ff;
	border:none;
	width:260px;
	color:white;
	border-radius:32px;
	font-size:18px;
	text-decoration:none;
	font-weight:bold;
	transition: all .3s ease-in;
	text-align:center;
	paddind:50%;
	
	
}
 .btn:hover{
	background:transparent;
	color:#7b89ec;
	border:2px solid #7b89ec;
}

.btn-left{
float:left;
color:white;
display:bolck;
}
.header{
	padding: 14px;
	text-align:center;
	background:#6c6cf2;
	color:#ffffff;
	font-size: 14px;
	font-weight:bold;

}
.rect{
height: 50px;
width: 100px;
background-image:url("a2.jsp");
}
</style>
<body>
	<div class="header">
<h2>Fund Transaction</h2>
</div>
<br>
<%@include file="SideNavigation.jsp" %>
<%@include file="repeat.jsp" %>
<form action="LoginPinController" method="post">
<center>

<table>
		<tr>
		<br><td><h2>Enter Your Password:</h2> </td>
		<td><input type="password" name="password" autocomplete="off"></td><br><br><br><br>
	    </tr>
</table>
	<br>	 
	
				<h1 style="text-align: center;"><input type="submit" name="save" value="Ok" class="btn"></h1>
		</form>

</center>
</form>

	 						
</body>
</html>