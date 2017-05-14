<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/login.css">
	<link rel="shortcut icon" type="image/x-icon" href="imgs/ano_white.png">
	<title>Login - Hackeet</title>
</head>
<body>
	<div class="container">
		<header>
			<div class="left">
				<a href="home">
					<img class="headerImg" src="imgs/ano.png" alt="icon">
					<p class="title">Hackeet</p>
				</a>
			</div>
			<div class="center">
				
			</div>
			<div class="right">
				<div class="register"><a href="register">Register</a></div>
				<div class="login"><a href="login">Login</a></div>
			</div>
		</header>
		<form action="login" method="POST">
			<div class="header">
				<div class="img-head">
					<img src="imgs/ano.png" alt="img">
				</div>
				<p>LOGIN</p>
			</div>
			<input type="text" name="user" placeholder="Username*" autofocus required minlength=4 maxlength=10>
			<input type="password" name="pass" placeholder="Password*" required>
			
			<button class="btn-submit" id="send">Submit</button>
		</form>
	</div>
</body>
</html>