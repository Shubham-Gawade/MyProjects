<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="SideNavigation.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<div class="header">
<form action="LogoutController">
		<h1 style="text-align: center;"><input type="submit" name="save" value="Logout" class="btn" style="float: left"></h1><br>
	</form>
<h2> SMP Bank</h2>
</div>
<link rel="stylesheet" type="text/css" href="profile.css">
<link rel="stylesheet" type="text/css" href="home.css">
<style>
.container{
	width:300px;
	background-color:#6c6cf2;
	color:#ffffff;
	}</style>
</head>
<body>
<link rel="stylesheet" type="text/css" href="profile.css">

		</center>
<marquee><h3>Wel-Come To SMP Bank!!! Wel-Come To SMP Bank!!! Wel-Come To SMP Bank!!!  Wel-Come To SMP Bank!!!  Wel-Come To SMP Bank!!!  Wel-Come To SMP Bank!!!</h3></marquee>
		<table>
			<tr>
				<td>
					<form action="MyProfileController" method="post" >
						<h1 style="text-align: center;"><input type="submit" name="save" value="My Profile" class="btn" style="float: left"></h1><br>
					</form>
				</td>
			</tr>
		<tr>
			<td>
				<form action="FundTransferController" method="post">
					<h1 style="text-align: center;"><input type="submit" name="save" value="Fund Transfer" class="btn" style="float: left"></h1><br>
				</form>
				</td>
		</tr>
		<tr>
			<td>
				<form action="Report.jsp" method="post">
					<h1 style="text-align: center;"><input type="submit" name="save" value="Report" class="btn" style="float: left"></h1><br>
				</form>
				</td>
		</tr>
		<tr>
			<td>
				<form action="Setting.jsp">
					<h1 style="text-align: center;"><input type="submit" name="save" value="Setting" class="btn" style="float: left"></h1><br>
				</form>
			</td>
		<tr>
			<td>
				<form action="Help.jsp">
					<h1 style="text-align: center;"><input type="submit" name="save" value="Help" class="btn" style="float: left"></h1><br>
				</form>
			</td>
		</tr>
		</td>
		</tr>
		</table>
		
		<div class="footer">
<h3>Our Bank is Online Banking. Our Bank offers customer almost
 every service tradtionally available through a local branch including deposits,transfer
  and online bill Payments. The payment that enables customers of a bank or other financial institution to 
  conduct a range of financial transation through the financial institution website.</h3>	
<div class="slide-left">
<p><h2>"Work Until Your Bank Account Looks Like A Phone Number"</h2></p>
</div>
		
</div>
		
		
</body>
</html>