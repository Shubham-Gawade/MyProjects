<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
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
.card-container{
	width:450px;
	height:290px;
	background:#fff;
	border-radius: 6px;
	position: absolute;
	top:40%;
	left:45%;
	transfrom:translate(-50%,-50%);
	box-shadow:0px 1px 10px 1px #000;
	overflow:hidden;
	display:inline-block;
	
}
.lower-container{
	height:400px;
	background: #fff;
	padding:70px;
	padding-top:129px;
	padding-left:60px;
	}
.header{
	padding: 14px;
	text-align:center;
	background:#6c6cf2;
	color:#ffffff;
	font-size: 14px;
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
<div class="card-container">

		<div class="btn-left">
		<div class="lower-container">
	 			 				<ul><li> <a href="LoginPassword.jsp" class="btn"><span class="glyphicon glyphicon-lock"></span>Generate A Pin</a></li></ul>
	 			 				
</div>
</div>
</div>
</body>
</html>