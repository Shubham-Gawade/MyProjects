<%@ include file="SideNavigation.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<div class="header">
	<form action="LogoutController">
		<h1 style="text-align: center;"><input type="submit" name="save" value="Logout" class="btn" style="float: left"></h1><br>
	</form>
	<h2> Setting</h2>
</div>

<link rel="stylesheet" type="text/css" href="profile.css">
<link rel="stylesheet" type="text/css" href="home.css">
<style>
.button{
 background-color:#6c6cf2;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  border-radius:25px;
}

</style>
<link rel="stylesheet" href="tabledesign.css">
</head>
<body>
<%@include file="repeat.jsp" %>

</div>
<center>
	<div id="id1">
			<h2 style="text-align: center;">Setting page</h2>
		</div>

		<form action="EnterLogin1.jsp" method="post">
			<h1 style="text-align: center;"><input type="submit" name="save" value="Change UserId" class="button"></h1>
		</form>
		<form action="EnterLogin2.jsp" method="post">
			<h1 style="text-align: center;"><input type="submit" name="save" value="Change Password" class="button"></h1>
		</form>
		<form action="EnterLogin3.jsp" method="post">
			<h1 style="text-align: center;"><input type="submit" name="save" value="Change PIN" class="button"></h1>
		</form>
		<form action="EnterLogin4.jsp" method="post">
			<h1 style="text-align: center;"><input type="submit" name="save" value="Change Mobile Number" class="button"></h1>
		</form>
		<form action="EnterLogin5.jsp" method="post">
			<h1 style="text-align: center;"><input type="submit" name="save" value="Change Email Id" class="button"></h1>
		</form>
	
	</center>
	</body>
</html>