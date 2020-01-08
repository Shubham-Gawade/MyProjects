<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction</title>
</head>
<style>
.header{
	padding: 14px;
	text-align:center;
	background:#6c6cf2;
	color:#ffffff;
	font-size: 15px;
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
	<form action="LogoutController">
		<h1 style="text-align: center;"><input type="submit" name="save" value="Logout" class="btn" style="float: left"></h1><br>
	</form>
	
	<div class="header">
	<%!String pin; %>
		
		<%
			if(!session.isNew())
			{
				pin=(String)session.getAttribute("pin");
				if(pin=="Invalid")
				{
		%>
				<h2>Fund Transaction</h2>
				</div>
				<br>
				<%@include file="SideNavigation.jsp" %>
				<%@include file="repeat.jsp" %>
				<center>
				<div class=".lower-container">
				<form action="IntraBankingController" method="post">
				
					<table>
					<tr>
						<td><h3>Invalid Account no./Pin</h3></td>	
					</tr>
					<tr>
					<td><h3>Account No:</h3></td>
						<td><input type="text" pattern="[0-9]{12}" name="Accno" title="Only 12 digits" autocomplete="off" size="30"></td><br><br>
					</tr>
					
					<tr>
					<td><h3>Amount:</h3></td>
					<td><input type="text" name="Amount" onkeypress="return event.charCode>=48 && event.charCode<=57" autocomplete="off" size="30"></td><br><br>
					</tr>
					
					<tr>
					<td><h3>Pin:</h3></td>
					<td><input type="password" pattern="[0-9]{4}" name="pin" title="Only 4 digits" autocomplete="off" size="30"></td><br><br>
					</tr>
					</table>
						
					<h1 style="text-align: center;"><input type="submit" name="save" value="Transfer" class="btn"></h1>
				</form>
						   
				</div>	
				</center>
		<%
				}
				else
				{
		%>
		<div class="header">
		<div class="topright"><span class="glyphicon glyphicon-log-out">LogOut</span></div>
		<h2>Fund Transaction</h2>
		</div>
		<br>
		<%@include file="repeat.jsp" %>
		<center>
		<div class=".lower-container">
		<form action="IntraBankingController" method="post">
		
		<table>
		<tr>
		<td><h3>Account No:</h3></td>
			<td><input type="text" pattern="[0-9]{12}" name="Accno" title="Only 12 digits" autocomplete="off" size="30"></td><br><br>
		</tr>
		
		<tr>
		<td><h3>Amount:</h3></td>
		<td><input type="text" name="Amount" onkeypress='return event.charCode>=48 && event.charCode<=57' autocomplete="off" size="30"/></td><br><br>
		</tr>
		
		<tr>
		<td><h3>Pin:</h3></td>
		<td><input type="password" pattern="[0-9]{4}" name="pin" title="Only 4 digits" autocomplete="off" size="30"></td><br><br>
		</tr>
		</table>
			
						<h1 style="text-align: center;"><input type="submit" name="save" value="Transfer" class="btn"></h1>
				</form>
				   
		</div>	
		</center>
		<%
				}
			}
		%>
</body>
</html>