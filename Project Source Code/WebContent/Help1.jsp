<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	nav{
	width:100%;
	height:80px;
	background-color:blue;
	top:0;
	line-height:80px;
	
}
nav ul{
	float:right;
	margin-right:150px;
}
nav ul li{
	list-style-type:none;
	display:inline-block;
	transition:0.8s all;
}

nav ul li:hover{
	background-color:#f39d1a;
}	
nav ul li a{
	text-decoration:none;
	color:#fff;
	padding:20px;
}
.helpbutton{ 
	background-color:violet;
}
</style>
</head>
<body>
<div id="navigation">

	<nav>
	
	<img src="logo1.jpg" width="80" height="80">
	
		<ul>
			<li><a href="home.jsp">HOME</a></li>
			<li><a href="CreateAccount.jsp">CREATE ACCOUNT</a></li>
		</ul>
	</nav>
</div>

<center>
<button type="button" class="helpbutton">
          <h1><span class="glyphicon glyphicon-question-sign"></span>Help</h1>
        </button></center> 
<p><font size="5">1.First for using our online banking services,you need to have account in our bank.<br>
	2.If you don't have account in our bank then first create your account by clicking on create account link provided on home page.<br>
	3.Once you click create account ,one registration form will be open.<br>
	4.Fill out all your details properly.<br>
	5.Click on submit button.<br>
	6.If all filled details are correct then you will receive one mail from bank containing your account number,password,user id.<br>
	7.You can change your password later using settings.<br> 
	8.If you haven't filled valid details,then you will receive mail like your account has not been created,fill out your valid details in registration form<br>
	9.You can login to your account by using userid & password provided in your account confirmation mail.<br></font>
<form action="home.jsp">
			<h4 style="text-align: center;"><input type="submit" name="save" value="OK" class="btn"></h1>
	</form>
</body>
</html>