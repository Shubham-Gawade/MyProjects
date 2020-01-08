<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="design.css">
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

	<div class="login-box">
	<img src="page3.jpg" class="aavtar">
	<h1>Login Here</h1>
	<form action="LoginAccountController" method="post">
	<p>Username</p>
	<input type="text" name="username" placeholder="Enter Username">
	<p>Password</p>
	<input type="password" name="password" placeholder="Enter Password">
	<input type="submit" name="submit" value="Login">
	<a href="#">Forget Password</a>
	</form>
	</div>
</body>
</html>