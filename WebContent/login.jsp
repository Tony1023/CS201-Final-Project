<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="FinalProject.css">
	<meta charset="UTF-8">
	<title>Log In</title>

	<script>

	function validate(){

		var requeststr = "Login?";

		requeststr += "email=" + document.LoginForm.email.value;
		requeststr += "&password=" + document.LoginForm.password.value;

		var xhttp = new XMLHttpRequest();
		xhttp.open("GET", requeststr, false);
		xhttp.send();

		if(xhttp.responseText.trim().length > 0){
			document.getElementById("err_message").innerHTML = xhttp.responseText;
			return false;
		}
		return true;


	}

	</script>
</head>
<body>

	<h1 id = "header"> Mingle SC </h1>

	<div id = "form">

		<h2 id="header">Log In Page</h2>

		<p id = "err_message" style="color: red; font-weight: bold"></p>
		<form id = "Login" name = "LoginForm" method = "GET" action = "ProfilePage.jsp" onsubmit = "return validate();">
			<br>
			<h3>Please enter the following:</h3>
			Email:<br><input type = "text" name = "email"><br>
			Password:<br><input type = "password" name = "password"><br>
		</form>
		<br>
		<button type = "submit" form = "Login" value = "Submit">Log In</button>


		<br><br>

		<div id = "button" style="width: 45%; margin-left: 190px">
		<form id = "CreateAccount" action = "CreateAccount.jsp" style ="float:left">
			<button type = "submit">Create Account</button>
		</form>

		<form id = "Guest" action = "GuestProfile.jsp">
			<button type = "submit">Continue as Guest</button>
		</form>
		<br><br>
		</div>

	</div>







</body>
</html>
