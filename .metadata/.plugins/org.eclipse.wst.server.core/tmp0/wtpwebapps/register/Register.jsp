<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="models.BeanUser" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/style.css">
	<link rel="shortcut icon" type="image/x-icon" href="imgs/ano_white.png">
	<title>Register</title>
</head>
<body>
	<% 
	BeanUser user = null;
	if (request.getAttribute("user")!=null) {
	user = (BeanUser)request.getAttribute("user");
}
else {
user = new BeanUser();
}
%>
<div class="container">
	<form action="Register" method="POST" id="reg">
		<div class="header">
			<div class="img-head">
				<img src="imgs/ano.png" alt="img">
			</div>
			<p>SIGN UP</p>
		</div>
		<input type="text" name="username" value="<%=user.getUser() %>" placeholder="Username*" autofocus required minlength=4 maxlength=10>
		<input type="email" name="mail" value="<%=user.getMail() %>" placeholder="Email*" required>
		<input type="password" name="pass1" value="<%=user.getPass() %>" placeholder="Password*" required>
		<input type="password" name="pass2" value="<%=user.getUser() %>" placeholder="Repeat Password" required>
		<input type="text" name="birthday" value="<%=user.getBirthD() %>" placeholder="Birthday*" required>
		<input type="text" name="team" value="<%=user.getTeam() %>" placeholder="Team Name">
		<h5>*Required</h5>
		<button class="btn-submit" id="send">Submit</button>
	</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="js/register.js"></script>
<script src="js/app.js"></script>
</body>
</html>