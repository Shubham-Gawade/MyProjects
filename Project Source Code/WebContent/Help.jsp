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
	<center>
<button type="button" class="helpbutton">
          <h1><span class="glyphicon glyphicon-question-sign"></span>Help</h1>
        </button></center> 
	
		
	</nav>
</div>
	<center> <button type="button" class="helpbutton">
          <h1><span class="glyphicon glyphicon-question-sign"></span>Help</h1>
        </button></center>
        <p><font size="5">1.After logging to your account you will be driven to dashboard.<br>
        2.There are different modules likes fund transfer,Profile Info,setting,report.<br>
        3.You can view your account related information by clicking on My Profile button.<br>
        4.If you want to do transaction then click on Fund-Transfer button provided on dashboard.<br>
        5.If this is your first transaction then you need to generate transaction pin first.<br>
        6.Click on Generate pin button in order to generate transaction pin.<br>
        7.Before generating transaction pin you need to enter your login password for security purpose.<br>
        8.Then generate transaction pin.<br>
        9.After generating transaction pin again click on transfer  button.<br>
        10.Enter beneficiary's account no.,total amount to be credited & transaction pin.<br>
        11.Click on transfer button.<br>
        12.with the help of setting button you can change your user_id,password,email_id,phone_no,transaction pin.<br></font><p>
    <form action="Welcome.jsp">
			<h4 style="text-align: center;"><input type="submit" name="save" value="OK" class="btn"></h1>
	</form>
</body>
</html>